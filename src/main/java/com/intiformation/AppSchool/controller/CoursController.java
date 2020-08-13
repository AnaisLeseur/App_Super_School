package com.intiformation.AppSchool.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.EtudiantCours;
import com.intiformation.AppSchool.modele.Matiere;
import com.intiformation.AppSchool.modele.Promotion;
import com.intiformation.AppSchool.service.ICoursService;
import com.intiformation.AppSchool.service.IEtudiantCoursService;
import com.intiformation.AppSchool.service.IEtudiantService;
import com.intiformation.AppSchool.service.IMatiereService;
import com.intiformation.AppSchool.service.IPromotionService;
import com.intiformation.AppSchool.validator.CoursValidator;

@Controller // declaration de la classe comme controller spring mvc
public class CoursController {

	// declaration de la couche service
	@Autowired
	private ICoursService coursService;
	
	@Autowired
	private IMatiereService matiereService;

	@Autowired
	private IEtudiantService etudiantService;

	@Autowired
	private IEtudiantCoursService etudiantCoursService;

	@Autowired
	private CoursValidator coursValidator;

	@Autowired
	private IPromotionService promotionService;
	
	

	public void setMatiereService(IMatiereService matiereService) {
		this.matiereService = matiereService;
	}

	public void setEtudiantService(IEtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	public void setEtudiantCoursService(IEtudiantCoursService etudiantCoursService) {
		this.etudiantCoursService = etudiantCoursService;
	}

	public void setPromotionService(IPromotionService promotionService) {
		this.promotionService = promotionService;
	}

	/**
	 * setter de la couche service pour injection spring
	 * 
	 * @param employeService
	 */
	public void setCoursService(ICoursService coursService) {
		this.coursService = coursService;
	}

	public void setCoursValidator(CoursValidator coursValidator) {
		this.coursValidator = coursValidator;
	}

	// ------------------------------------ methode
	// gestionnaire--------------------------

	@InitBinder({ "coursCommand", "coursModifCommand", "coursBindPromo" })
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", orderDateEditor);
	}

	// ------------------------------------------------------//
	// -----------------Get Cours-------------------------//
	// ------------------------------------------------------//

	@RequestMapping(value = "/cours/see-cours/{coursID}", method = RequestMethod.GET)
	public ModelAndView ConsulterEtudiant(@PathVariable("coursID") int pId) {

		Cours cours = coursService.findByIdCours(pId);

		// Return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("seeCours", "coursSeeCommand", cours);
	}

	@RequestMapping(value = "/cours/liste", method = RequestMethod.GET)
	public String recupererListeMatiereBDD(ModelMap model) {

		// 1. recup de la liste des employés dans la bdd via le service
		List<Cours> listeCoursBdd = coursService.findAllCours();

		// 2. on utilise model pour renvoyer la liste vers la vue
		model.addAttribute("attribut_liste_cours", listeCoursBdd);
		
		// récup de la liste des matières disponibles pour faire l'association
		List<Matiere> listeMatiereBddPourAssos = matiereService.findAllMatiere();
		
		// on utilise model pour renvoyer la liste des matieres vers la vue 
		model.addAttribute("attribut_listeMatiereBddPourAssos", listeMatiereBddPourAssos);
		
		
		Cours cours = new Cours();
		model.addAttribute("attribut-cours", cours);
		
		// 3 renvoi du nom logique de la vue
		/**
		 * > resolution de la vue par le viewResolver :
		 * 
		 * liste-cours ====> WEB-INF/views/liste-cours.jsp
		 */
		return "liste-cours";

	}// end recupListe

	/**
	 * permet de supprimer
	 * 
	 * @return accolade dans value si on eut definir pmlsieur url
	 */
	@RequestMapping(value = { "/cours/delete/{cours-id}", "/cours/remove/{cours-id}" }, method = RequestMethod.GET)
	public String supprimerMatiere(@PathVariable("cours-id") int pIdCours, ModelMap model) {

		// 1 . suppresion de matiere dans la bdd via le service

		coursService.supprimerCours(pIdCours);

		// 2 . recup de la nouvelle liste des employe
		List<Cours> listeCoursBdd = coursService.findAllCours();

		// 4bis ou 4
		// 3 . envoie des données à afficher dans la vue
		model.addAttribute("attribut_liste_cours", listeCoursBdd);

		// 4 bis
		// return "liste-cours";

		// 4 redirection vers l'url /cours/liste pour invoquer la méthode
		// recupererListeEmployeeBdd
		// et nous rediriger vers liste-matiere.jsp

		return "redirect:/cours/liste";

	}// end suppr

	@RequestMapping(value = "/cours/add-cours-form", method = RequestMethod.GET)
	// ou @GetMapping au lieu du method = ....
	public ModelAndView afficherFormulaireAjout() {

		// 1 definition d'un objet de commmande qui va permettre la liaision avec les
		// champs du formulaire

		// 1.1 l'objet de commande (c'est un objet employé vide)
		Cours cours = new Cours();

		// 1.2 affectation d'un nomà l'objet de commande (par défaut : command)
		String nomObjetCommande = "coursCommand";

		// 2. envoie de l'objet de commande vers la vue (page du formulaire)
		Map<String, Object> dataCommand = new HashMap<>();
		dataCommand.put(nomObjetCommande, cours);

		// 3. def du nom logique de la vue
		/**
		 * > resolution de la vue par le view resolveur :
		 * 
		 * ajout-employe ==========> /WEB-INF/views/ajout-employe
		 */
		String viewname = "ajouter-cours";

		// 4. envoie de l'objet modelAndView vers la servlet
		return new ModelAndView(viewname, dataCommand);

	}// end afficherFormulaire

	/**
	 * permet d'ajouter un employé dans la bdd cette methode est invoqué à la
	 * soumission du formulaire ajout dans ajouter-employe.jsp cette methode est
	 * invoquée avec une requete http en post et l'url "/employes/add" cette methode
	 * recupere l'objet de commande qui s'appelle "employeCommand" lié au formulaire
	 * 
	 * @return nom logique de la vue
	 * @param resultatValidation
	 *            contient le resultat du process de la validation
	 */
	@RequestMapping(value = "/cours/add", method = RequestMethod.POST)
	public String ajouterEmployeBDD(@ModelAttribute("coursCommand") @Validated Cours pCours, ModelMap model,
			BindingResult resultatValidation) {

		// validation de l'objet pEmploye
		coursValidator.validate(pCours, resultatValidation);

		// validation
		if (resultatValidation.hasErrors()) {

			// la validation a détécté des erreurs
			// -> redirection vers la page du formulaire ajouter-employe
			return "ajouter-cours"; // nom de la view

		} else {

			// la validation n'a pas détécté d'erreur

			// 1 ajout de l'employé à la bdd via le service via la couche service
			coursService.ajouterCours(pCours);

			// 2. redirection vers la page liste-employes.jsp

			// 2.1. recup nouvelle liste + envoie de la liste
			model.addAttribute("attribut_liste_cours", coursService.findAllCours());

			return "redirect:/cours/liste";
		} // end else

	}// end ajouter coursBDD

	@RequestMapping(value = "/cours/update-cours-form", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireModificationCours(@RequestParam("idcours") int pCoursId) {

		// 1 recup de l'employé à modifier via son id dans la bdd
		Cours coursAModifier = coursService.findByIdCours(pCoursId);

		// 2. def du model de donnée (objet de commande nommé "employeModifCommand") +
		// def du nom logique de la vue
		// + => ajout du modele et du nom dans l'objet ModelAndView

		return new ModelAndView("modifier-cours", "coursModifCommand", coursAModifier);

		/**
		 * modifier-employe = /WEB-INF/views/modifier-employe.jsp
		 * 
		 * 
		 */

	}// affichferFormulaireModificationCours

	/**
	 * permet de modifier un employé dans la bdd cette methode est invoqué à la
	 * soumission du formulaire ajout dans modifier-employe.jsp cette methode est
	 * invoquée avec une requete http en post et l'url "/employes/update" cette
	 * methode recupere l'objet de commande qui s'appelle "employeModifCommand" lié
	 * au formulaire
	 * 
	 * @return nom logique de la vue
	 */
	@RequestMapping(value = "/cours/update", method = RequestMethod.POST)
	public String ModifierCoursBDD(@ModelAttribute("coursModifCommand") Cours pModifcours, ModelMap model) {

		// 1. modif dans la bdd via la couche service
		coursService.modfierCours(pModifcours);

		// 2 recup de la nouelle liste employé
		model.addAttribute("attribut_liste_cours", coursService.findAllCours());

		return "redirect:/cours/liste";
	}// end modifier

	// --------------------------------------------------------//
	// ----------------Binding Promotion-----------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/cours/linkPromotion/{coursID}", method = RequestMethod.GET)
	public String toLinkPromotion(@PathVariable("coursID") int pId, ModelMap model) {

		model.addAttribute("coursBindPromo", coursService.findByIdCours(pId));

		model.addAttribute("liste_Promotion", promotionService.findListNotLinkedToCours(pId));

		return "LinkPromotionToCours";
	}// end toLinkPromotion

	/**
	 * Conversion des id des promotions en objet Promotion
	 * 
	 * @param binder
	 */
	@InitBinder
	public void bindingPreparationPromo(WebDataBinder binder) {

		binder.registerCustomEditor(List.class, "promotionControllerCours", new CustomCollectionEditor(List.class) {

			protected Object convertElement(Object element) {

				if (element != null) {
					Integer Id = Integer.parseInt(element.toString());
					Promotion promo = promotionService.findById(Id);
					return promo;
				} // end if

				return null;
			}

		});
	}// end InitBinder

	/**
	 * Lie l'étudiant aux promotions sélectionnées
	 * 
	 * @param etudiant
	 * @return View
	 */
	@RequestMapping(value = "/promotion/bindPromotionToCours", method = RequestMethod.POST)
	public String BindPromotionToCours(@ModelAttribute("coursBindPromo") Cours pCours) {

		coursService.modfierCours(pCours);

		Promotion promotion = pCours.getPromotion();

		List<Cours> listeCours = promotion.getListeCours();

		// Si pEtudiant n'est pas dans la liste de la promotion, on l'ajoute
		if (listeCours.indexOf(pCours) == -1) {

			listeCours.add(pCours);
			promotion.setListeCours(listeCours);
			promotionService.modifier(promotion);
		} // end if

		return "redirect:/promotion/liste";
	}// end BindPromotionToEtudiant()

	@RequestMapping(value = "/cours/deletePromotion", method = RequestMethod.GET)
	public ModelAndView DeletePromotionFromEtudiant(@RequestParam("idPromo") int idPromotion,
			@RequestParam("idCours") int idCours) {

		// Recup de la promotion
		Promotion promotion = promotionService.findById(idPromotion);

		// Suppression de l'etudiant de la propriété listeEtudiant de Promotion
		List<Cours> listeEtudiant = promotion.getListeCours();

		int index = 0;

		for (Cours etudiants : listeEtudiant) {
			if (etudiants.getIdCours() == idCours) {
				break;
			}
			index++;
		}
		
		listeEtudiant.remove(index);


		// Sauvegarde dans la BDD
		promotion.setListeCours(listeEtudiant);
		promotionService.modifier(promotion);

		// Renvoi de l'etudiant dans la vue seeEtudiant
		return new ModelAndView("Cours/seeEtudiant", "coursSeeCommand", coursService.findByIdCours(idCours));
	}

		
		
		
		/**
		 * Lier le cours à une matière
		 * 
		 * @param 
		 * @return View
		 */
		@RequestMapping(value = "/cours/linkToMatiere", method = RequestMethod.POST)
		public String CoursMatiereLink(@ModelAttribute("attribut-cours") Cours pCours) {
			// récup du cours à modifier 
			// récup de la metière choisie 
			int idMatiere = pCours.getMatiere().getIdMatiere();
			
			Matiere matiere = matiereService.findByIdMatiere(idMatiere);
			Cours coursMatiere = coursService.findByIdCours(pCours.getIdCours());
			// 	
			coursMatiere.setMatiere(matiere);
			
			// modification du cours dans la bdd 
			coursService.modfierCours(coursMatiere);
				
			return "redirect:/cours/liste";
			
		}// end BindPromotionToEtudiant()

		

	// --------------------------------------------------------//
	// --------------Binding EtudiantCours---------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/cours/linkEtudiantCours/{coursID}", method = RequestMethod.GET)
	public String toLinkEtudiantCours(@PathVariable("coursID") int pId, ModelMap model) {

		model.addAttribute("coursBindEtudiantCours", coursService.findByIdCours(pId));

		model.addAttribute("liste_Etudiants", coursService.findListEtudiantNotLinkedToCours(pId));

		return "LinkEtudiantToCours";
	}// end toLinkPromotion

	/**
	 * Conversion des id des cours et des id des étudiants en objet EtudiantCours
	 * 
	 * @param binder
	 */
	@InitBinder({"coursBindEtudiantCours"})
	public void bindingPreparationEtudiantCours(WebDataBinder binder) {
		System.out.println("---------------------------------------------------");
		System.out.println("dans le binder Cours attribution etudiant");
		System.out.println("---------------------------------------------------");
		binder.registerCustomEditor(List.class, "listeEtudiantsCours", new CustomCollectionEditor(List.class) {

			protected Object convertElement(Object element) {

				if (element != null) {
					String[] stringSplit = element.toString().split("-");

					Integer IdCours = Integer.parseInt(stringSplit[0]);
					Cours cours = coursService.findByIdCours(IdCours);

					Integer IdEtudiant = Integer.parseInt(stringSplit[1]);
					Etudiant etudiant = etudiantService.findById(IdEtudiant);

					return new EtudiantCours(etudiant, cours, null, "");
				} // end if

				return null;
			}

		});
	}// end InitBinder

	/**
	 * Lie l'étudiant aux cours sélectionnées
	 * 
	 * @param etudiant
	 * @return View
	 */
	@RequestMapping(value = "/cours/bindEtudiantToCours", method = RequestMethod.POST)
	public String BindCoursToEtudiant(@ModelAttribute("coursBindEtudiantCours") Cours cours) {

		// Recuperation de la liste des EtudiantCours
		List<EtudiantCours> listeEtudiantCours = cours.getListeEtudiantsCours();

		// Ajout des EtudiantCours dans la BDD
		for (EtudiantCours etudiantCours : listeEtudiantCours) {
			etudiantCoursService.ajouter(etudiantCours);
		}

		return "redirect:/cours/liste";
	}// end BindCoursToEtudiant()

	// delete

	@RequestMapping(value = "/cours/edit-form-EtudiantCours/{coursId}", method = RequestMethod.GET)
	public ModelAndView AfficherFormEtudiantCours(@PathVariable("coursId") int idCours) {

		// Renvoi de l'etudiant dans la vue seeEtudiant 
		return new ModelAndView("formAppelEtudiantCours", "AppelEtudiantCommand",coursService.findByIdCours(idCours));
	}
	
	@InitBinder({"AppelEtudiantCommand"})
	public void bindingPreparationAppel(WebDataBinder binder) {
		System.out.println("---------------------------------------------------");
		System.out.println("dans le binder Cours appel");
		System.out.println("---------------------------------------------------");
		binder.registerCustomEditor(List.class, "listeEtudiantsCours", new CustomCollectionEditor(List.class) {

			protected Object convertElement(Object element) {

				if (element != null) {

					Integer IdEtudiantCours = Integer.parseInt(element.toString());
					EtudiantCours etudiantCours = etudiantCoursService.findById(IdEtudiantCours);

					return etudiantCours;
				} // end if

				return null;
			}

		});
	}
	
	@RequestMapping(value ="/cours/AppelEtudiantsFromCours", method = RequestMethod.POST) 
	public String AppelEtudiantCoursFromCours(@ModelAttribute("AppelEtudiantCommand") Cours cours,@RequestParam("checkboxAbsence") String[] listeAbsence,
			@RequestParam("motif") String[] listeMotif) {
		
		int index=0;
		for (EtudiantCours ec : cours.getListeEtudiantsCours()) {
			
			ec.setMotif(listeMotif[index]);
			ec.setAbsence(listeAbsence[index].equals("1")?true:false);
			
			etudiantCoursService.modifier(ec);
			index++;
		}
			  
		return "redirect:/cours/liste"; 
	}// end AppelEtudiantCoursFromCours()
	
	/*
	 *  A adapter, provient de Etudiant Controller
	 * 
	 * @RequestMapping(value = "/etudiants/deleteEtudiantCours", method =
	 * RequestMethod.GET) public ModelAndView
	 * DeleteCoursFromEtudiant(@RequestParam("idEtudiantCours") int idEtudiantCours,
	 * 
	 * @RequestParam("idEtudiant") int idEtudiant) {
	 * 
	 * etudiantCoursService.supprimer(idEtudiantCours);
	 * 
	 * // Renvoi de l'etudiant dans la vue seeEtudiant return new
	 * ModelAndView("Etudiant/seeEtudiant", "etudiantSeeCommand",
	 * etudiantService.findById(idEtudiant)); }
	 * 
	 * 
	 */

}// end controller

