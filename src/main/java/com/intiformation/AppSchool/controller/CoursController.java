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
import com.intiformation.AppSchool.service.ICoursService;
import com.intiformation.AppSchool.validator.CoursValidator;

@Controller // declaration de la classe comme controller spring mvc
public class CoursController {

	// declaration de la couche service
	@Autowired
	private ICoursService coursService;
	
	@Autowired
	private CoursValidator coursValidator;

	/**
	 * setter de la couche service pour injection spring
	 * @param employeService
	 */
	public void setCoursService(ICoursService coursService) {
		this.coursService = coursService;
	}
	
	public void setCoursValidator(CoursValidator coursValidator) {
		this.coursValidator = coursValidator;
	}
	
	//------------------------------------ methode gestionnaire--------------------------
	
	



	@RequestMapping(value="/cours/liste" , method=RequestMethod.GET)
	public String recupererListeMatiereBDD(ModelMap model) {
		
		// 1. recup de la liste des employés dans la bdd via le service
		List<Cours> listeCoursBdd = coursService.findAllCours();
		
		// 2. on utilise model pour renvoyer la liste vers la vue 
		model.addAttribute("attribut_liste_cours", listeCoursBdd);
		
		// 3 renvoi du nom logique de la vue
		/**
		 * > resolution de la vue par le viewResolver :
		 * 
		 *     liste-cours ====> WEB-INF/views/liste-cours.jsp
		 */
		return "liste-cours";
		
	}//end recupListe
	
	/**
	 * permet de supprimer
	 * @return
	 * accolade dans value si on eut definir pmlsieur url
	 */
	@RequestMapping(value= {"/cours/delete/{cours-id}" , "/cours/remove/{cours-id}" }, method=RequestMethod.GET)
	public String supprimerMatiere(@PathVariable("cours-id") int pIdCours, ModelMap model) {
		
		// 1 . suppresion de matiere dans la bdd via le service
		
		coursService.supprimerCours(pIdCours);
		
		//2 . recup de la nouvelle liste des employe
		List<Cours> listeCoursBdd = coursService.findAllCours();
		
		// 4bis ou 4
		//3 . envoie des données à afficher dans la vue
		model.addAttribute("attribut_liste_cours", listeCoursBdd);
		
		//4 bis
		//return "liste-cours";
		
		// 4 redirection vers l'url /cours/liste pour invoquer la méthode recupererListeEmployeeBdd
		// et nous rediriger vers liste-matiere.jsp
		
		return "redirect:/cours/liste";
		
	}// end suppr
	
	
	@RequestMapping(value="/cours/add-cours-form", method=RequestMethod.GET)
	// ou @GetMapping au lieu du method = .... 
	public ModelAndView afficherFormulaireAjout() {
		
		//1 definition d'un objet de commmande qui va permettre la liaision avec les champs du formulaire
		
		//1.1 l'objet de commande (c'est un objet employé vide)
		Cours cours = new Cours();
		
		// 1.2 affectation d'un nomà l'objet de commande (par défaut : command)
		String nomObjetCommande = "coursCommand";
		
		// 2. envoie de l'objet de commande vers la vue (page du formulaire)
		Map<String, Object> dataCommand = new HashMap<>();
		dataCommand.put(nomObjetCommande, cours);
		
		//3. def du nom logique de la vue 
		/**
		 * > resolution de la vue par le view resolveur :
		 * 
		 * ajout-employe ==========> /WEB-INF/views/ajout-employe
		 */
		String viewname = "ajouter-cours";
		
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
	@RequestMapping(value="/cours/add", method=RequestMethod.POST)
	public String ajouterEmployeBDD(@ModelAttribute("coursCommand") @Validated Cours pCours,
			                        ModelMap model, BindingResult resultatValidation ) {
		
		//validation de l'objet pEmploye
		coursValidator.validate(pCours, resultatValidation);
		
		//validation
		if (resultatValidation.hasErrors()) {
			
			// la validation a détécté des erreurs
			//-> redirection vers la page du formulaire ajouter-employe
			return "ajouter-cours"; // nom de la view
			
		} else {
			
			// la validation n'a pas détécté d'erreur

		//1 ajout de l'employé à la bdd via le service via la couche service
		coursService.ajouterCours(pCours);
		
		//2. redirection vers la page liste-employes.jsp
		
		//2.1. recup nouvelle liste + envoie de la liste
		 model.addAttribute("attribut_liste_cours", coursService.findAllCours())   ;
		
		
		return "redirect:/cours/liste";
		}//end else
		
		
		
	}//end ajouter coursBDD
	
	@RequestMapping(value="/cours/update-cours-form" , method=RequestMethod.GET)
	public ModelAndView afficherFormulaireModificationCours(@RequestParam("idcours") int pCoursId) {
		
		// 1 recup de l'employé à modifier via son id dans la bdd
		Cours coursAModifier = coursService.findByIdCours(pCoursId);
		
		// 2. def du model de donnée (objet de commande nommé "employeModifCommand") + def du nom logique de la vue 
		// + => ajout du modele et du nom dans l'objet ModelAndView
		
		return new ModelAndView("modifier-cours", "coursModifCommand", coursAModifier);
		
		/**
		 * modifier-employe = /WEB-INF/views/modifier-employe.jsp
		 * 
		 * 
		 */
		
	}//affichferFormulaireModificationCours
	
	/**
	 * permet de modifier un employé dans la bdd
	 * cette methode est invoqué à la soumission du formulaire
	 * ajout dans modifier-employe.jsp
	 * cette methode est invoquée avec une requete http en post et l'url 
	 * "/employes/update"
	 * cette methode recupere l'objet de commande qui s'appelle "employeModifCommand" lié au formulaire
	 * @return nom logique de la vue
	 */
	@RequestMapping(value="/cours/update", method=RequestMethod.POST)
	public String ModifierCoursBDD(@ModelAttribute("coursModifCommand") Cours pModifcours, ModelMap model) {
		
		// 1. modif dans la bdd via la couche service
		coursService.modfierCours(pModifcours);
		
		//2 recup de la nouelle liste employé
		model.addAttribute("attribut_liste_cours", coursService.findAllCours());
		
		return "redirect:/cours/liste";
	}//end modifier
	
	
	
}//end controller