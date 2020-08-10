package com.intiformation.AppSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.AppSchool.modele.Aide;
import com.intiformation.AppSchool.service.IAideService;
import com.intiformation.AppSchool.validator.AideValidator;


@Controller
public class AideController {

	// declaration de la couche service
	@Autowired
	private IAideService aideService;

	@Autowired
	private AideValidator aideValidator;

	//Setter

	public void setAideService(IAideService aideService) {
		this.aideService = aideService;
	}

	public void setAideValidator(AideValidator aideValidator) {
		this.aideValidator = aideValidator;
	}
	
	

	// --------------------------------------------------------//
	// ------------------------Get Aide------------------------//
	// --------------------------------------------------------//
	
	@RequestMapping(value = "/aide/liste", method = RequestMethod.GET)
	public String recupererListeAide(ModelMap model) {

		// Recup de la liste des aides
		List<Aide> listeAideBdd = aideService.findAll();

		// On utilise model pour renvoyer la liste vers la vue
		model.addAttribute("attribut_liste_aide", listeAideBdd);

		// Renvoi du nom logique de la vue
		return "Aide/ListeAide";

	}// end recupListe
	
	
	@RequestMapping(value = "/aide/see-aide/{aideId}", method = RequestMethod.GET)
	public ModelAndView GetAide(@PathVariable("aideId") int pIdAide) {

		// Recuperation de l'aide dans la BDD
		Aide aide = aideService.findById(pIdAide);

		// Redirection vers la page seeAide.jsp dans le dossier Aide
		return new ModelAndView("Aide/seeAide", "aideSeeCommand", aide );

	}// end suppr
	
	
	
	// --------------------------------------------------------//
	// --------------Suppression Aide--------------------------//
	// --------------------------------------------------------//	

	@RequestMapping(value = "/aide/delete/{aideId}", method = RequestMethod.GET)
	public String supprimerAide(@PathVariable("aideId") int pIdAide) {

		// Suppresion de l'aide dans la BDD
		aideService.supprimer(pIdAide);

		// Redirection
		return "redirect:/aide/liste";

	}// end suppr

	
	
	// --------------------------------------------------------//
	// --------------------Ajout Aide--------------------------//
	// --------------------------------------------------------//
	
	/**
	 * permet d'afficher le formulaire d'ajout d'une aide cette methode est
	 * invoquée suite au click du lien "Ajout d'une aide"
	 * /aide/add-aide-form
	 * 
	 * @return
	 */
	@RequestMapping(value = "/aide/add-aide-form", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {

		Aide aide = new Aide();

		// return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Aide/addAide", "aideAddCommand", aide);

	}// end afficherFormulaire

	/**
	 * Permet d'ajouter une aide dans la BDD. Cette methode est invoqué à la
	 * soumission du formulaire ajout dans addAide.jsp cette methode est
	 * invoquée avec une requete http en post et l'url "aide/add" cette methode
	 * recupere l'objet de commande qui s'appelle "aideAddCommand" lié au formulaire
	 * 
	 * @return nom logique de la vue
	 * @param resultatValidation
	 *            contient le resultat du process de la validation
	 */
	@RequestMapping(value = "/aide/add", method = RequestMethod.POST)
	public String ajouterAide(@ModelAttribute("aideAddCommand") @Validated Aide pAide, ModelMap model,
			BindingResult resultatValidation) {

		// Validation de l'objet pAide
		aideValidator.validate(pAide, resultatValidation);

		// Validation
		if (resultatValidation.hasErrors()) {

			// la validation a détecté des erreurs
			// -> redirection vers la page du formulaire ajouter-aide
			return "ajouter-aide"; 

		} else {

			// la validation n'a pas détecté d'erreur
			// Ajout de l'aide dans la BDD
			aideService.ajouter(pAide);

			// Redirection
			return "redirect:/aide/liste";
		} // end else

	}// end ajouterAide

	/**
	 *
	 * permet d'afficher le formulaire de modif d'un employé cette methode est
	 * invoquée suite au click du lien "Modif d'un employé" de liste-employes.jsp
	 * /employes/update-employe-form?idemploye=1
	 * 
	 * @return
	 */
	@RequestMapping(value = "/aide/update-aide-form/{aideId}", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireModification(@PathVariable("aideId") int pIdAide) {

		// 1 recup de l'employé à modifier via son id dans la bdd
		Aide aideToUpdate = aideService.findById(pIdAide);

		// 2. def du model de donnée (objet de commande nommé "employeModifCommand") +
		// def du nom logique de la vue
		// + => ajout du modele et du nom dans l'objet ModelAndView

		return new ModelAndView("Aide/updateAide", "aideModifCommand", aideToUpdate);

		/**
		 * modifier-employe = /WEB-INF/views/modifier-employe.jsp
		 * 
		 * 
		 */

	}// affichferFormulaireModificationMatiere

	/**
	 * permet de modifier un employé dans la bdd cette methode est invoqué à la
	 * soumission du formulaire ajout dans modifier-employe.jsp cette methode est
	 * invoquée avec une requete http en post et l'url "/employes/update" cette
	 * methode recupere l'objet de commande qui s'appelle "employeModifCommand" lié
	 * au formulaire
	 * 
	 * @return nom logique de la vue
	 */
	@RequestMapping(value = "/aide/update", method = RequestMethod.POST)
	public String ModifierMatiereBDD(@ModelAttribute("aideModifCommand") Aide pModifaide) {

		// Modification dans la BDD 
		aideService.modifier(pModifaide);

		//Redirection
		return "redirect:/aide/liste";
	}// end modifier

}// end controller
