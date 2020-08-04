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

import com.intiformation.AppSchool.modele.Enseignant;
import com.intiformation.AppSchool.service.IEnseignantService;
import com.intiformation.AppSchool.validator.EnseignantValidator;



/**
 * implementation d'un controleur spring mvc pour la gestion des enseignants.
 * Gestion opération CRUD de l'enseignant
 * @author anais
 *
 */
@Controller // déclaration de la classe comme bean spring de type controleur spring mvc 
public class EnseignantController {

	// déclaration service
	@Autowired // injection du bean de la couche service dans cette prop 'enseignantService'
	private IEnseignantService enseignantService;

	
	// déclaration du validateur
	@Autowired
	private EnseignantValidator enseignantValidator; 
	
	
	/**
	 * setter de la couche service pour injection spring 
	 * 
	 * @param enseignantService
	 */
	@Autowired
	public EnseignantController(IEnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}


	/**
	 * setter pour le validateur pour injection spring 
	 * 
	 * @param enseignantValidator
	 */
	public void setAdminValidator(EnseignantValidator enseignantValidator) {
		this.enseignantValidator = enseignantValidator;
	}
	
	

	//----------------- METHODES --------------------
	// Meths gestionnaires du controleur 
	
	/**
	 * methode pour la recup de la liste des enseignants de la bdd via le service 
	 * cette meth est invoquée via une rqt http en get  

	 * @param model : modele de données à renvoyer vers la vue
	 * @return: le nom logique de la vue 
	 */
	@RequestMapping(value="enseignants/liste", method=RequestMethod.GET)
	public String recupererListeEnseignantsBdd(ModelMap model) {
		
		// 1. récup de la liste des enseignants dans la bdd via le service 
		List<Enseignant> listeEnseignantsBdd = enseignantService.findAll();
		
		// 2. renvoie de la liste vers la vue via l'objet 'model' (le param) de type ModelMap
		model.addAttribute("attribut_liste_enseignants", listeEnseignantsBdd);
		
		// 3. renvoi du nom logique de la vue 
		/**
		 * résolution de la vue par le viewResolver:
		 */
		return "Personnel/liste-enseignants";
		
	}// end recupererListeEnseignantsBdd	
	
	
	
	
	/**
	 * permet de supprimer un enseignant dans la bdd avec son id via le service 
	 * 
	 * @return : le nom logique de la vue 
	 * 
	 */
	@RequestMapping(value= {"/enseignants/delete/{enseignantId}"}, method=RequestMethod.GET)
	public String supprimerEnseignantBdd(@PathVariable("enseignantId") int pIdEnseignant, ModelMap model) {
		
		// 1. suppression de l'enseignant dans la bdd via le service 
		enseignantService.supprimer(pIdEnseignant);
	
		//  redirection vers l'url '/enseignants/liste' pour invoquer la methode 'recupererListeEnseignantsBdd' 
		return "redirect:/enseignants/liste";
	
	}// end supprimerEnseignantBdd
	
	
	/**
	 * permet d'afficher le formulaire d'ajout pour un enseignant.
	 * meth invoquée suite au click du lien 'ajouter un enseignant' de 'liste-enseigants.jsp'
	 * @return: le nom logique de la vue 
	 */
	@RequestMapping(value="/enseignants/add-enseignant-form", method=RequestMethod.GET)
	public ModelAndView afficherFormAjoutEnseignant() {
		
		// 1. definition d'un objet de commande qui va permettre la liaison avec les champs
		// 1.1 l'object de commande => c'est un objet Enseignant vide 
		Enseignant enseignant = new Enseignant();
		
		// 1.2 affectation d'un nom à l'objet de commande (par defaut : command)
		String nomObjCommande = "enseignantCommand";
		
		// 2. envoi de l'objet de commande vers la vue (page du formulaire)
		Map<String, Object> dataCommand = new HashMap<>();
		dataCommand.put(nomObjCommande, enseignant);
		
		// 3. definition du nom logique de la vu
		/**
		 * résolution de la vue par le viewResolver:
		 */
		String viewName = "Personnel/ajouter-enseignant";
		
		// 4. envoi de l'objet ModelAndView vers la servlet DispatcherServlet
		return new ModelAndView(viewName, dataCommand);
						
	}// end afficherFormAjoutEnseignant()
	
	
	/**
	 * methode pour ajouter un enseignant dans la bdd .
	 * meth invoquée à la sousmission du formulaire d'ajout dans 'ajouter-enseignant.jsp".
	 * meth invoquée avec une Rqt http en post et l'url '/enseignants/add'.
	 * meth récupère l'objet de commande 'enseignantCommand' lié au formulaire via @ModelAttribute
	 * 	et le met dans pEnseignant
	 * 
	 * @param resultatValidation : contient le résultat du process de la validation 
	 * @return: le nom logique de la vue (redirection)
	 */
	@RequestMapping(value="/enseignants/add", method=RequestMethod.POST)
	public String ajouterEnseignantBdd(@ModelAttribute("enseignantCommand") @Validated Enseignant pEnseignant, 
									ModelMap model,
									BindingResult resultatValidation) {
		
		// application du validateur sur l'objet pEnseignant
		enseignantValidator.validate(pEnseignant, resultatValidation);
		
		// validation
		if (resultatValidation.hasErrors()) {
			
			// si on entre dans le IF => la validation a détecté des erreurs
			
			// => redirection vers la page du formulaire d'ajout : 'Personnel/ajouter-enseignant.jsp"
			return "Personnel/ajouter-enseignant"; // nom logique de la vue 
			
		} else {
			
			// la validation n'a pas détecté d'erreurs

		// 1. ajout de l'enseignant à la bdd via la couche service 
		enseignantService.ajouter(pEnseignant);
		
		// 2. redirection vers la page liste-enseignants.jsp
		return "redirect:/enseignants/liste";

		}// end else
	}// end ajouterEnseignantBdd
	
	
	/**
	 * permet d'afficher le formulaire de modification d'un enseignant.
	 * meth invoquée suite au click du lien 'modifier' de 'liste-enseignants.jsp'
	 * meth invoquée avec une rqt http en get
	 * 
	 * @return: le nom logique de la vue 
	 */
	@RequestMapping(value="/enseignants/update-enseignant-form", method=RequestMethod.GET)
	public ModelAndView afficherFormModificationEnseignant(@RequestParam("idEnseignant") int pIdEnseignant) {
		
		// 1. récup de l'enseignant à modifier via son id dans la bdd
		Enseignant enseignantAModifier = enseignantService.findById(pIdEnseignant);
		
		// 2. definition du model de données (l'objet de commande nommé 'enseignantAModifier') 
		//		+ definition du nom logique de la vue 'modifier-enseignant' + ajout du modele et du nom dans un objet ModelAndView
		return new ModelAndView("Personnel/modifier-enseignant", "enseignantModifCommand", enseignantAModifier);
		
	}// end afficherFormModificationEnseignant
	
	
	
	/**
	 * methode pour modifier un enseignant dans la bdd .
	 * meth invoquée à la sousmission du formulaire de modification de la page 'modifier-enseignant.jsp".
	 * meth invoquée avec une Rqt http en post et l'url '/enseignants/update'.
	 * meth récupère l'objet de commande 'enseignantModifCommand' lié au formulaire via @ModelAttribute
	 * 	et le met dans pEnseignantToUpdate
	 * @return: le nom logique de la vue (redirection)
	 */
	@RequestMapping(value="/enseignants/update", method=RequestMethod.POST)
	public String modifierEnseignantBdd(@ModelAttribute("enseignantModifCommand") Enseignant pEnseignantToUpdate, ModelMap model) {
		
		// 1. modif de l'enseignant dans la bdd via service
		enseignantService.modifier(pEnseignantToUpdate);
		
		// 3. renvoi du nom de la vue logique de la vue :
		return "redirect:/enseignants/liste";
		
	}// end modifierEnseignantBdd
}// end class
