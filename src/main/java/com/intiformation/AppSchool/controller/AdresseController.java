package com.intiformation.AppSchool.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.AppSchool.modele.Adresse;
import com.intiformation.AppSchool.service.IAdresseService;

@Controller
public class AdresseController {
	
	@Autowired
	private IAdresseService adresseService;

	public void setAdresseService(IAdresseService adresseService) {
		this.adresseService = adresseService;
	}

	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@RequestMapping(value = "/adresse/liste", method = RequestMethod.GET)
	public String recupererListeEmployeBdd(ModelMap model) {

		// Renvoi de la liste vers la vue
		model.addAttribute("attribut_listeAdresses", adresseService.findAll());

		// Renvoi du nom logique de la vue
		return "Adresse/listeAdresse";
	}// end recupererListeEmployeBdd()

	// --------------------------------------------------------//
	// -----------------Ajout Adresse-------------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/adresses/add-adresse-form", method = RequestMethod.GET)
	public ModelAndView AfficherFormulaireAdd() {

		// return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Adresse/addAdresse", "adresseAddCommand", new Adresse());

	}// end AfficherFormulaire()

	@RequestMapping(value = "adresse/add", method = RequestMethod.POST)
	public String ajouterAdressesBDD(@ModelAttribute("adresseAddCommand") Adresse pAdresse, ModelMap model) {

		// 1.ajout de l'employe à la bdd via la couche service
		adresseService.ajouter(pAdresse);

		// 2.redirection vers la methode de la recup de la liste
		return "redirect:/adresse/liste";

	}

	// --------------------------------------------------------//
	// -------------Modification Adresse----------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/adresses/update-adresse-form/{adresseID}", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireModification(@PathVariable("adresseID") int pId) {

		// Return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Adresse/updateAdresse", "adresseUpdateCommand", adresseService.findById(pId));
	}
	

	@RequestMapping(value = "/adresse/update", method = RequestMethod.POST)
	public String modifierEmployesBDD(@ModelAttribute("adresseUpdateCommand") Adresse pAdresse) {

		// 1.Modification de l'étudiant dans la BDD
		adresseService.modifier(pAdresse);

		// 2.Redirection
		return "redirect:/adresse/liste";
	}

	// --------------------------------------------------------//
	// --------------Suppression Adresse----------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/adresses/delete/{adresseID}", method = RequestMethod.GET)
	public String supprimerEmployesBdd(@PathVariable("adresseID") int pId) {

		// Suppression de l'adresse dans la BDD
		adresseService.supprimer(pId);

		// Redirection
		return "redirect:/adresse/liste";
	}

}
