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

import com.intiformation.AppSchool.modele.Aide;
import com.intiformation.AppSchool.modele.Matiere;
import com.intiformation.AppSchool.service.IAideService;
import com.intiformation.AppSchool.validator.AideValidator;


@Controller
public class AideController {

	// declaration de la couche service
			@Autowired
			private IAideService aideService;

			@Autowired
			private AideValidator aideValidator;

			
			
			
			//setter 
			
			public void setAideService(IAideService aideService) {
				this.aideService = aideService;
			}

			public void setAideValidator(AideValidator aideValidator) {
				this.aideValidator = aideValidator;
			}
			
			//-----------methode gestionnaire du controlleur -------------
			@RequestMapping(value="/aide/liste" , method=RequestMethod.GET)
			public String recupererListeMatiereBDD(ModelMap model) {
				
				// 1. recup de la liste des employés dans la bdd via le service
				List<Aide> listeAideBdd = aideService.findAll();
				
				// 2. on utilise model pour renvoyer la liste vers la vue 
				model.addAttribute("attribut_liste_aide", listeAideBdd);
				
				// 3 renvoi du nom logique de la vue
				/**
				 * > resolution de la vue par le viewResolver :
				 * 
				 *     liste-Matiere ====> WEB-INF/views/liste-Matiere.jsp
				 */
				return "liste-aide";
				
			}//end recupListe
			
			/**
			 * permet de supprimer
			 * @return
			 * accolade dans value si on eut definir pmlsieur url
			 */
			@RequestMapping(value= {"/aide/delete/{aide-id}" , "/aide/remove/{aide-id}" }, method=RequestMethod.GET)
			public String supprimerMatiere(@PathVariable("aide-id") int pIdAide, ModelMap model) {
				
				// 1 . suppresion de matiere dans la bdd via le service
				
				aideService.supprimer(pIdAide);
				
				//2 . recup de la nouvelle liste des employe
				List<Aide> listeAideBdd = aideService.findAll();
				
				// 4bis ou 4
				//3 . envoie des données à afficher dans la vue
				model.addAttribute("attribut_liste_aide", listeAideBdd);
				
				//4 bis
				//return "liste-matiere";
				
				// 4 redirection vers l'url /matiere/liste pour invoquer la méthode recupererListeEmployeeBdd
				// et nous rediriger vers liste-matiere.jsp
				
				return "redirect:/aide/liste";
				
			}// end suppr
			
			/**
			 * permet d'afficher le formulaire d'ajout d'un employé
			 * cette methode est invoquée suite au click du lien "Ajout d'un employé"
			 * de liste-employes.jsp /employes/add-employe-form
			 * @return
			 */
			@RequestMapping(value="/aide/add-aide-form", method=RequestMethod.GET)
			// ou @GetMapping au lieu du method = .... 
			public ModelAndView afficherFormulaireAjout() {
				
				//1 definition d'un objet de commmande qui va permettre la liaision avec les champs du formulaire
				
				//1.1 l'objet de commande (c'est un objet employé vide)
				Aide aide = new Aide();
				
				// 1.2 affectation d'un nomà l'objet de commande (par défaut : command)
				String nomObjetCommande = "aideCommand";
				
				// 2. envoie de l'objet de commande vers la vue (page du formulaire)
				Map<String, Object> dataCommand = new HashMap<>();
				dataCommand.put(nomObjetCommande, aide);
				
				//3. def du nom logique de la vue 
				/**
				 * > resolution de la vue par le view resolveur :
				 * 
				 * ajout-matiere ==========> /WEB-INF/views/ajout-matiere
				 */
				String viewname = "ajouter-aide";
				
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
			@RequestMapping(value="/aide/add", method=RequestMethod.POST)
			public String ajouterMatiereBDD(@ModelAttribute("aideCommand") @Validated Aide pAide,
					                        ModelMap model, BindingResult resultatValidation ) {
				
				//validation de l'objet pAide
				aideValidator.validate(pAide, resultatValidation);
				
				//validation
				if (resultatValidation.hasErrors()) {
					
					// la validation a détécté des erreurs
					//-> redirection vers la page du formulaire ajouter-aide
					return "ajouter-aide"; // nom de la view
					
				} else {
					
					// la validation n'a pas détécté d'erreur

				//1 ajout de aide à la bdd via le service via la couche service
					aideService.ajouter(pAide);
				
				//2. redirection vers la page liste-aide.jsp
				
				//2.1. recup nouvelle liste + envoie de la liste
				 model.addAttribute("attribut_liste_aide", aideService.findAll())   ;
				
				
				return "redirect:/aide/liste";
				}//end else
				
				
				
			}//end ajouter aideBDD
			
			/**
			 *
			 * permet d'afficher le formulaire de modif d'un employé
			 * cette methode est invoquée suite au click du lien "Modif d'un employé"
			 * de liste-employes.jsp /employes/update-employe-form?idemploye=1
			 * @return
			 */
			@RequestMapping(value="/aide/update-aide-form" , method=RequestMethod.GET)
			public ModelAndView afficherFormulaireModificationMatiere(@RequestParam("idaide") int pAideId) {
				
				// 1 recup de l'employé à modifier via son id dans la bdd
				Aide aideAModifier = aideService.findById(pAideId);
				
				// 2. def du model de donnée (objet de commande nommé "employeModifCommand") + def du nom logique de la vue 
				// + => ajout du modele et du nom dans l'objet ModelAndView
				
				return new ModelAndView("modifier-aide", "aideModifCommand", aideAModifier);
				
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
			@RequestMapping(value="/aide/update", method=RequestMethod.POST)
			public String ModifierMatiereBDD(@ModelAttribute("aideModifCommand") Aide pModifaide, ModelMap model) {
				
				// 1. modif dans la bdd via la couche service
				aideService.modifier(pModifaide);
				
				//2 recup de la nouelle liste employé
				model.addAttribute("attribut_liste_aide", aideService.findAll());
				
				return "redirect:/aide/liste";
			}//end modifier
			
	
	
}//end controller
