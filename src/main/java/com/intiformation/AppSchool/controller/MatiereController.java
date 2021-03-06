package com.intiformation.AppSchool.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.EnseigneJointure;
import com.intiformation.AppSchool.modele.Matiere;
import com.intiformation.AppSchool.service.ICoursService;
import com.intiformation.AppSchool.service.IEnseignantService;
import com.intiformation.AppSchool.service.IEnseigneJointureService;
import com.intiformation.AppSchool.service.IMatiereService;
import com.intiformation.AppSchool.validator.MatiereValidator;



@Controller // declaration de la classe comme controller spring mvc
public class MatiereController {

	// declaration de la couche service
	@Autowired
	private IMatiereService matiereService;

	@Autowired
	private MatiereValidator matiereValidator;
	
	// déclaration de la couche service de Cours 
	@Autowired
	private ICoursService coursService;
	
	// déclaration de la couche service de EnseigneJointure 
	@Autowired
	private IEnseigneJointureService enseigneJointureService;
		
		
		/**
		 * setter de la couche service pour injection spring
		 * @param employeService
		 */
		public void setMatiereService(IMatiereService matiereService) {
			this.matiereService = matiereService;
		}

		
		public void setMatiereValidator(MatiereValidator matiereValidator) {
			this.matiereValidator = matiereValidator;
		}

		
		// Getter et setter pour coursService 
		public ICoursService getCoursService() {
			return coursService;
		}


		public void setCoursService(ICoursService coursService) {
			this.coursService = coursService;
		}
		
		// Getter et setter pour enseigneJointureService
		public IEnseigneJointureService getEnseigneJointureService() {
			return enseigneJointureService;
		}


		public void setEnseigneJointureService(IEnseigneJointureService enseigneJointureService) {
			this.enseigneJointureService = enseigneJointureService;
		}
		
		


		//-----------methode gestionnaire du controlleur -------------
		@RequestMapping(value="/matiere/liste" , method=RequestMethod.GET)
		public String recupererListeMatiereBDD(ModelMap model) {
			
			// 1. recup de la liste des employés dans la bdd via le service
			List<Matiere> listeMatiereBdd = matiereService.findAllMatiere();
			
			// 2. on utilise model pour renvoyer la liste vers la vue 
			model.addAttribute("attribut_liste_matiere", listeMatiereBdd);
			
			// 3 renvoi du nom logique de la vue
			/**
			 * > resolution de la vue par le viewResolver :
			 * 
			 *     liste-Matiere ====> WEB-INF/views/liste-Matiere.jsp
			 */
			return "liste-matiere";
			
		}//end recupListe




		/**
		 * permet de supprimer
		 * @return
		 * accolade dans value si on eut definir pmlsieur url
		 */
		@RequestMapping(value= {"/matiere/delete/{matiere-id}" , "/matiere/remove/{matiere-id}" }, method=RequestMethod.GET)
		public String supprimerMatiere(@PathVariable("matiere-id") int pIdMatiere, ModelMap model) {
			
			// récup des cours associés à la matière a supprimer 
			List<Cours> listeCoursAssoMatierASupp = coursService.recupCoursParMatiere(pIdMatiere);
			
			for (Cours cours : listeCoursAssoMatierASupp) {
	            cours.setMatiere(null);
	            coursService.modfierCours(cours);
	        }
			
			// récup des enseigneJointure associées à la matière a supprimer 
			List<EnseigneJointure> listeEnsJointAssoMatierASupp = enseigneJointureService.recupEJAvecIdMatiere(pIdMatiere);
			
			for (EnseigneJointure enseigneJointure : listeEnsJointAssoMatierASupp) {
				int idEJASupp = enseigneJointure.getIdEnseigneJointure();
				
				System.out.println("int idEJASupp =" + idEJASupp);
				
				enseigneJointureService.supprimer(idEJASupp);
			}
			
			
			
			// 1 . suppresion de matiere dans la bdd via le service
			
			matiereService.supprimerMatiere(pIdMatiere);
			
			//2 . recup de la nouvelle liste des employe
			List<Matiere> listeMatiereBdd = matiereService.findAllMatiere();
			
			// 4bis ou 4
			//3 . envoie des données à afficher dans la vue
			model.addAttribute("attribut_liste_matiere", listeMatiereBdd);
			
			//4 bis
			//return "liste-matiere";
			
			// 4 redirection vers l'url /matiere/liste pour invoquer la méthode recupererListeEmployeeBdd
			// et nous rediriger vers liste-matiere.jsp
			
			return "redirect:/matiere/liste";
			
		}// end suppr
		
		
		
		/**
		 * permet d'afficher le formulaire d'ajout d'un employé
		 * cette methode est invoquée suite au click du lien "Ajout d'un employé"
		 * de liste-employes.jsp /employes/add-employe-form
		 * @return
		 */
		@RequestMapping(value="/matiere/add-matiere-form", method=RequestMethod.GET)
		// ou @GetMapping au lieu du method = .... 
		public ModelAndView afficherFormulaireAjout() {
			
			//1 definition d'un objet de commmande qui va permettre la liaision avec les champs du formulaire
			
			//1.1 l'objet de commande (c'est un objet employé vide)
			Matiere matiere = new Matiere();
			
			// 1.2 affectation d'un nomà l'objet de commande (par défaut : command)
			String nomObjetCommande = "matiereCommand";
			
			// 2. envoie de l'objet de commande vers la vue (page du formulaire)
			Map<String, Object> dataCommand = new HashMap<>();
			dataCommand.put(nomObjetCommande, matiere);
			
			//3. def du nom logique de la vue 
			/**
			 * > resolution de la vue par le view resolveur :
			 * 
			 * ajout-matiere ==========> /WEB-INF/views/ajout-matiere
			 */
			String viewname = "ajouter-matiere";
			
			//4. envoie de l'objet modelAndView vers la servlet
			return new ModelAndView(viewname, dataCommand);
			
		}//end afficherFormulaire
		
		/**
		 * permet d'ajouter un employé dans la bdd
		 * cette methode est invoqué à la soumission du formulaire
		 * ajout dans ajouter-employe.jsp
		 * cette methode est invoquée avec une requete http en post et l'url 
		 * "/employes/add"
		 * cette methode recupere l'objet de commande qui s'appelle "employeCommand" lié au formulaire
		 * @return nom logique de la vue
		 * @param resultatValidation contient le resultat du process de la validation
		 */
		@RequestMapping(value="/matiere/add", method=RequestMethod.POST)
		public String ajouterMatiereBDD(@ModelAttribute("matiereCommand") @Validated Matiere pMatiere,
				                        ModelMap model, BindingResult resultatValidation ) {
			
			//validation de l'objet pEmploye
			matiereValidator.validate(pMatiere, resultatValidation);
			
			//validation
			if (resultatValidation.hasErrors()) {
				
				// la validation a détécté des erreurs
				//-> redirection vers la page du formulaire ajouter-employe
				return "ajouter-matiere"; // nom de la view
				
			} else {
				
				// la validation n'a pas détécté d'erreur

			//1 ajout de l'employé à la bdd via le service via la couche service
			matiereService.ajouterMatiere(pMatiere);
			
			//2. redirection vers la page liste-employes.jsp
			
			//2.1. recup nouvelle liste + envoie de la liste
			 model.addAttribute("attribut_liste_matiere", matiereService.findAllMatiere())   ;
			
			
			return "redirect:/matiere/liste";
			}//end else
			
			
			
		}//end ajouter matiereBDD
		
		/**
		 *
		 * permet d'afficher le formulaire de modif d'un employé
		 * cette methode est invoquée suite au click du lien "Modif d'un employé"
		 * de liste-employes.jsp /employes/update-employe-form?idemploye=1
		 * @return
		 */
		@RequestMapping(value="/matiere/update-matiere-form" , method=RequestMethod.GET)
		public ModelAndView afficherFormulaireModificationMatiere(@RequestParam("idmatiere") int pMatiereId) {
			
			// 1 recup de l'employé à modifier via son id dans la bdd
			Matiere matiereAModifier = matiereService.findByIdMatiere(pMatiereId);
			
			// 2. def du model de donnée (objet de commande nommé "employeModifCommand") + def du nom logique de la vue 
			// + => ajout du modele et du nom dans l'objet ModelAndView
			
			return new ModelAndView("modifier-matiere", "matiereModifCommand", matiereAModifier);
			
			/**
			 * modifier-employe = /WEB-INF/views/modifier-employe.jsp
			 * 
			 * 
			 */
			
		}//affichferFormulaireModificationMatiere
		
		/**
		 * permet de modifier un employé dans la bdd
		 * cette methode est invoqué à la soumission du formulaire
		 * ajout dans modifier-employe.jsp
		 * cette methode est invoquée avec une requete http en post et l'url 
		 * "/employes/update"
		 * cette methode recupere l'objet de commande qui s'appelle "employeModifCommand" lié au formulaire
		 * @return nom logique de la vue
		 */
		@RequestMapping(value="/matiere/update", method=RequestMethod.POST)
		public String ModifierMatiereBDD(@ModelAttribute("matiereModifCommand") Matiere pModifmatiere, ModelMap model) {
			
			// 1. modif dans la bdd via la couche service
			matiereService.modfierMatiere(pModifmatiere);
			
			//2 recup de la nouelle liste employé
			model.addAttribute("attribut_liste_matiere", matiereService.findAllMatiere());
			
			return "redirect:/matiere/liste";
		}//end modifier
		
		
		// --------------------------------------------------------//
		// ---------- Affichage liste COURS / MATIERE -------------//
		// --------------------------------------------------------//
		@RequestMapping(value = "/matiere/coursLinked/{idMatiere}", method = RequestMethod.GET)
		public String MatiereLinkedCours(@PathVariable("idMatiere") int pIdMatiere, ModelMap model) {

			model.addAttribute("listeCoursAssocMatiere", coursService.recupCoursParMatiere(pIdMatiere));

			return "link-matiere-cours";
		}// end toLinkPromotion
		
		
		
		
		
}//end controller
