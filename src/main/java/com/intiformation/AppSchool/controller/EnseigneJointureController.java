package com.intiformation.AppSchool.controller;

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

import com.intiformation.AppSchool.modele.EnseigneJointure;
import com.intiformation.AppSchool.modele.EtudiantCours;
import com.intiformation.AppSchool.service.IEnseignantService;
import com.intiformation.AppSchool.service.IEnseigneJointureService;
import com.intiformation.AppSchool.service.IMatiereService;
import com.intiformation.AppSchool.service.IPromotionService;
import com.intiformation.AppSchool.validator.EnseigneJointureValidator;

@Controller
public class EnseigneJointureController {

	@Autowired
	private IEnseigneJointureService enseigneJointureService;
	
	@Autowired
	private EnseigneJointureValidator ejValidator;

	@Autowired
	private IEnseignantService enseignantService;

	@Autowired
	private IPromotionService promotionService;

	@Autowired
	private IMatiereService matiereService;

	// Setter pour injection
	public void setEnseigneJointureService(IEnseigneJointureService enseigneJointureService) {
		this.enseigneJointureService = enseigneJointureService;
	}

	public void setEnseignantService(IEnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}

	public void setPromotionService(IPromotionService promotionService) {
		this.promotionService = promotionService;
	}

	public void setMatiereService(IMatiereService matiereService) {
		this.matiereService = matiereService;
	}
	
	public void setEjValidator(EnseigneJointureValidator ejValidator) {
		this.ejValidator = ejValidator;
	}
	
	// Methode

	@RequestMapping(value = "/enseigneJointure/liste/{id}/{type}", method = RequestMethod.GET)
	public String recupererListeEnseigneJointure(ModelMap model, @PathVariable("id") int id,
			@PathVariable("type") String type) {
		
		EnseigneJointure enseigneJointure = new EnseigneJointure();
		
		switch (type) {
		case "E":
			
			enseigneJointure.setEnseignantEJ(enseignantService.findById(id));
			model.addAttribute("enseigneJointureCommand", enseigneJointure);

			break;
		case "M":
			
			enseigneJointure.setMatiereEJ(matiereService.findByIdMatiere(id));
			model.addAttribute("enseigneJointureCommand", enseigneJointure);

			break;
		case "P":
			
			enseigneJointure.setPromotionEJ(promotionService.findById(id));
			model.addAttribute("enseigneJointureCommand", enseigneJointure);
			
			break;

		default:
			model.addAttribute("enseigneJointureCommand", enseigneJointure);
			break;
		}
		
		// Renvoi des listes Promo/Matiere/Ens vers la vue
		model.addAttribute("attribut_listeEnseignants", enseignantService.findAll());
		model.addAttribute("attribut_listePromotions", promotionService.findAll());
		model.addAttribute("attribut_listeMatieres", matiereService.findAllMatiere());
		
		model.addAttribute("attribut_listeEnseigneJointures", enseigneJointureService.findAll());

		// Renvoi du nom logique de la vue
		return "FormListEnseigneJointure";
	}// end recupererListeEnseigneJointure()
	
	
	@RequestMapping(value = "/enseigneJointure/addEnseigneJointure", method = RequestMethod.POST)
	public String AddEnseigneJointure(@ModelAttribute("enseigneJointureCommand") @Validated EnseigneJointure enseigneJointure,
			BindingResult bindingResult) {
		
		ejValidator.validate(enseigneJointure, bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			return "redirect:/enseigneJointure/liste/0/X";
		}
				
		int idEnseignant = enseigneJointure.getEnseignantEJ().getIdentifiant();
		int idPromotion = enseigneJointure.getPromotionEJ().getIdPromotion();
		int idMatiere = enseigneJointure.getMatiereEJ().getIdMatiere();
				
		if (idEnseignant!=0) {
			enseigneJointure.setEnseignantEJ(enseignantService.findById(idEnseignant));
		}
		
		if (idPromotion!=0) {
			enseigneJointure.setPromotionEJ(promotionService.findById(idPromotion));
		}
		
		if (idMatiere!=0) {
			enseigneJointure.setMatiereEJ(matiereService.findByIdMatiere(idMatiere));
		}
		
		enseigneJointureService.ajouter(enseigneJointure);
		
		return "redirect:/enseigneJointure/liste/0/X";
	}//end AddEnseigneJointure
	
	
	@RequestMapping(value = "/enseigneJointure/delete/{idEJ}", method = RequestMethod.GET)
	public String DeleteEnseigneJointure(@PathVariable("idEJ") int idEJ) {
		
		enseigneJointureService.supprimer(idEJ);		
	
		// Renvoi de l'etudiant dans la vue FormListEnseigneJointure
		return "redirect:/enseigneJointure/liste/0/X";
	}//DeleteEnseigneJointure()
	
	@RequestMapping(value = "/enseigneJointure/update-enseigneJointure-form/{idEJ}", method = RequestMethod.GET)
	public String AfficherFormEnseigneJointure(ModelMap model, @PathVariable("idEJ") int idEJ) {
		
		model.addAttribute("attribut_listeEnseignants", enseignantService.findAll());
		model.addAttribute("attribut_listePromotions", promotionService.findAll());
		model.addAttribute("attribut_listeMatieres", matiereService.findAllMatiere());
		
		model.addAttribute("enseigneJointureEditCommand", enseigneJointureService.findById(idEJ));

		// Renvoi de l'enseigneJointure dans la vue FormModifEnseigneJointure
		return "FormModifEnseigneJointure";
	}//AfficherFormEtudiantCours()   
	
	
	@RequestMapping(value ="/enseigneJointure/updateEJ", method = RequestMethod.POST)
	public String UpdateEnseigneJointure(@ModelAttribute("enseigneJointureEditCommand") @Validated EnseigneJointure enseigneJointure,
			BindingResult bindingResult) {

		ejValidator.validate(enseigneJointure, bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			return "redirect:/enseigneJointure/update-enseigneJointure-form/"+enseigneJointure.getIdEnseigneJointure();
		}

		//Recup de l'EtudiantCours contenant coursEC et etudianEC
		
		int idEnseignant = enseigneJointure.getEnseignantEJ().getIdentifiant();
		int idPromotion = enseigneJointure.getPromotionEJ().getIdPromotion();
		int idMatiere = enseigneJointure.getMatiereEJ().getIdMatiere();
		
		enseigneJointure.setEnseignantEJ(enseignantService.findById(idEnseignant));
		enseigneJointure.setPromotionEJ(promotionService.findById(idPromotion));
		enseigneJointure.setMatiereEJ(matiereService.findByIdMatiere(idMatiere));
		
		enseigneJointureService.modifier(enseigneJointure);
				
		return "redirect:/enseigneJointure/liste/0/X";
		
	}// end UpdateEnseigneJointure()

}
