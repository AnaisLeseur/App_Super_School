package com.intiformation.AppSchool.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.service.IEtudiantService;

@Controller
public class EtudiantController {

	@Autowired
	private IEtudiantService etudiantService;

	public void setEtudiantService(IEtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	@RequestMapping(value = "/etudiant/liste", method = RequestMethod.GET)
	public String recupererListeEmployeBdd(ModelMap model) {

		// Renvoi de la liste vers la vue
		model.addAttribute("attribut_listeEtudiants", etudiantService.findAll());

		// Renvoi du nom logique de la vue
		return "Etudiant/listeEtudiant";
	}// end recupererListeEmployeBdd()

	@RequestMapping(value = "/etudiants/add-etudiant-form", method = RequestMethod.GET)
	public ModelAndView AfficherFormulaireAdd() {

		// Objet de commande
		Etudiant etudiant = new Etudiant();

		// return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Etudiant/addEtudiant", "etudiantAddCommand", etudiant);

	}// end AfficherFormulaire()

	@RequestMapping(value = "/etudiants/add", method = RequestMethod.POST)
	public String ajouterEtudiantsBDD(@ModelAttribute("etudiantAddCommand") Etudiant pEtudiant) {

		// 1.ajout de l'employe à la bdd via la couche service
		etudiantService.ajouter(pEtudiant);

		// 2.redirection vers la methode de la recup de la liste
		return "redirect:/etudiant/liste";

	}

}
