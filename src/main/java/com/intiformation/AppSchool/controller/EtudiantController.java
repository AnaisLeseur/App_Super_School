package com.intiformation.AppSchool.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.AppSchool.cryptage.PasswordEncoderGenerator;
import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.EtudiantCours;
import com.intiformation.AppSchool.modele.Promotion;
import com.intiformation.AppSchool.service.ICoursService;
import com.intiformation.AppSchool.service.IEtudiantCoursService;
import com.intiformation.AppSchool.service.IEtudiantService;
import com.intiformation.AppSchool.service.IPromotionService;
import com.intiformation.AppSchool.validator.EtudiantValidator;

@Controller
public class EtudiantController {

	@Autowired
	private IEtudiantService etudiantService;
	
	@Autowired
	private IEtudiantCoursService etudiantCoursService;

	@Autowired
	private IPromotionService promotionService;
	
	@Autowired
	private ICoursService coursService;

	@Autowired
	private ServletContext context;

	@Autowired
	private EtudiantValidator etudiantValidator;

	// Setter pour injection
	
	
	public void setPromotionService(IPromotionService promotionService) {
		this.promotionService = promotionService;
	}

	public void setEtudiantCoursService(IEtudiantCoursService etudiantCoursService) {
		this.etudiantCoursService = etudiantCoursService;
	}

	public void setEtudiantValidator(EtudiantValidator etudiantValidator) {
		this.etudiantValidator = etudiantValidator;
	}

	public void setCoursService(ICoursService coursService) {
		this.coursService = coursService;
	}

	public void setEtudiantService(IEtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	@InitBinder({ "etudiantAddCommand", "etudiantUpdateCommand", "etudiantBindPromo","etudiantBindEtudiantCours" })
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "dateNaissance", orderDateEditor);
	}

	// ------------------------------------------------------//
	// -----------------Get Etudiant-------------------------//
	// ------------------------------------------------------//

	@RequestMapping(value = "/etudiant/liste", method = RequestMethod.GET)
	public String recupererListeEtudiants(ModelMap model) {

		// Renvoi de la liste vers la vue
		model.addAttribute("attribut_listeEtudiants", etudiantService.findAll());

		// Renvoi du nom logique de la vue
		return "Etudiant/listeEtudiant";
	}// end recupererListeEmployeBdd()

	@RequestMapping(value = "/etudiant/see-etudiant/{etudiantID}", method = RequestMethod.GET)
	public ModelAndView ConsulterEtudiant(@PathVariable("etudiantID") int pId) {

		Etudiant etudiant = etudiantService.findById(pId);

		// Return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Etudiant/seeEtudiant", "etudiantSeeCommand", etudiant);
	}

	// --------------------------------------------------------//
	// -----------------Ajout Etudiant-------------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/etudiants/add-etudiant-form", method = RequestMethod.GET)
	public ModelAndView AfficherFormulaireAdd() {

		Etudiant etudiant = new Etudiant();

		// return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Etudiant/addEtudiant", "etudiantAddCommand", etudiant);

	}// end AfficherFormulaire()

	@RequestMapping(value = "etudiant/add", method = RequestMethod.POST)
	public String ajouterEtudiant(@ModelAttribute("etudiantAddCommand") @Validated Etudiant pEtudiant,
			BindingResult bindingResult) {

		etudiantValidator.validateAdd(pEtudiant, bindingResult);

		if (bindingResult.hasErrors()) {

			return "Etudiant/addEtudiant";

		} else {

			// Partie pour cryptage MDP
			// récup du mdp mis dans le formulaire
			String MdpNonCrypt = pEtudiant.getMotDePasse();

			// invocation de la methode pour le cryptage
			String MdpCrypt = PasswordEncoderGenerator.cryptageMdP(MdpNonCrypt);

			pEtudiant.setMotDePasse(MdpCrypt);

			MultipartFile file = pEtudiant.getUploadedPhoto();

			// Ajout de l'etudiant à la BDD et recuperation de l'etudiant avec son id
			pEtudiant = etudiantService.ajouterReturnEtudiant(pEtudiant);

			// Definition du nom de la photo comme : 'identifiant.extension'
			pEtudiant.setPhoto(
					pEtudiant.getIdentifiant() + "." + FilenameUtils.getExtension(file.getOriginalFilename()));

			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Création du fichier dans /assets/images/photosS
					File serverFile = new File(
							context.getRealPath("/assets/images/photos") + File.separator + pEtudiant.getPhoto());

					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

					stream.write(bytes);

					stream.close();

				} catch (Exception e) {
					System.out.println("Probleme lors de la sauvegarde du fichier");
				}
			}

			// Update de la propriete photo de l'etudiant
			etudiantService.modifier(pEtudiant);

			// Redirection vers la methode de la recup de la liste
			return "redirect:/etudiant/liste";

		}

	}// end ajouterEtudiant()

	// --------------------------------------------------------//
	// -------------Modification Etudiant----------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/etudiants/update-etudiant-form/{etudiantID}", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireModification(@PathVariable("etudiantID") int pId) {

		// Return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Etudiant/updateEtudiant", "etudiantUpdateCommand", etudiantService.findById(pId));
	}// end afficherFormulaireModification()

	@RequestMapping(value = "/etudiant/update", method = RequestMethod.POST)
	public String modifierEtudiant(@ModelAttribute("etudiantUpdateCommand") @Validated Etudiant pEtudiant,
			BindingResult bindingResult) {

		etudiantValidator.validateAdd(pEtudiant, bindingResult);

		if (bindingResult.hasErrors()) {

			return "Etudiant/updateEtudiant";

		} else {

			// Si !( MDP BDD = MDP input ) alors cryptage du nouveau MDP
			if (!(etudiantService.findById(pEtudiant.getIdentifiant()).getMotDePasse()
					.equals(pEtudiant.getMotDePasse()))) {

				// Partie pour cryptage MDP
				// récup du mdp mis dans le formulaire
				String MdpNonCrypt = pEtudiant.getMotDePasse();

				// invocation de la methode pour le cryptage
				String MdpCrypt = PasswordEncoderGenerator.cryptageMdP(MdpNonCrypt);

				pEtudiant.setMotDePasse(MdpCrypt);
			}

			MultipartFile file = pEtudiant.getUploadedPhoto();

			if (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();

					// Création du fichier dans /assets/images/photosS
					File serverFile = new File(
							context.getRealPath("/assets/images/photos") + File.separator + pEtudiant.getPhoto());

					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));

					stream.write(bytes);

					stream.close();

				} catch (Exception e) {
					System.out.println("Probleme lors de la sauvegarde du fichier");
				}
			}

			//pEtudiant.setListePromotions(etudiantService.findListPromoByIdEtudiant(pEtudiant.getIdentifiant()));

			// Modification de l'étudiant dans la BDD
			etudiantService.modifier(pEtudiant);

			// Redirection
			return "redirect:/etudiant/liste";
		}
	}// end modifierEtudiant()

	// --------------------------------------------------------//
	// --------------Suppression Etudiant----------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/etudiants/delete/{etudiantID}", method = RequestMethod.GET)
	public String supprimerEtudiant(@PathVariable("etudiantID") int pId) {

		// Suppression de l'etudiant dans la BDD
		etudiantService.supprimer(pId);

		// Redirection
		return "redirect:/etudiant/liste";
	}

	// --------------------------------------------------------//
	// ----------------Binding Promotion-----------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/etudiant/linkPromotion/{etudiantID}", method = RequestMethod.GET)
	public String toLinkPromotion(@PathVariable("etudiantID") int pId, ModelMap model) {

		model.addAttribute("etudiantBindPromo", etudiantService.findById(pId));

		model.addAttribute("liste_Promotion", promotionService.findListNotLinkedToEtudiant(pId));

		return "Etudiant/LinkPromotionToEtudiant";
	}// end toLinkPromotion

	/**
	 * Conversion des id des promotions en objet Promotion
	 * 
	 * @param binder
	 */
	@InitBinder
	public void bindingPreparationPromo(WebDataBinder binder) {

		binder.registerCustomEditor(List.class, "listePromotions", new CustomCollectionEditor(List.class) {

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
	@RequestMapping(value = "/promotion/bindPromotionToEtudiant", method = RequestMethod.POST)
	public String BindPromotionToEtudiant(@ModelAttribute("etudiantBindPromo") Etudiant pEtudiant) {

		etudiantService.modifier(pEtudiant);

		//Promotion côté maitre de la relation
		//Obligation de faire l'update côté promotion
		List<Promotion> listePromoSelected = pEtudiant.getListePromotions();

		for (Promotion promotion : listePromoSelected) {

			List<Etudiant> listeEtudiant = promotion.getListeEtudiants();

			// Si pEtudiant n'est pas dans la liste de la promotion, on l'ajoute
			if (listeEtudiant.indexOf(pEtudiant) == -1) {

				listeEtudiant.add(pEtudiant);
				promotion.setListeEtudiants(listeEtudiant);
				promotionService.modifier(promotion);
			} // end if
		} // end for each

		return "redirect:/promotion/liste";
	}// end BindPromotionToEtudiant()

	@RequestMapping(value = "/etudiants/deletePromotion", method = RequestMethod.GET)
	public ModelAndView DeletePromotionFromEtudiant(@RequestParam("idPromo") int idPromotion,
			@RequestParam("idEtudiant") int idEtudiant) {

		// Recup de la promotion
		Promotion promotion = promotionService.findById(idPromotion);

		// Suppression de l'etudiant de la propriété listeEtudiant de Promotion
		List<Etudiant> listeEtudiant = promotion.getListeEtudiants();

		int index = 0;

		for (Etudiant etudiants : listeEtudiant) {
			if (etudiants.getIdentifiant() == idEtudiant) {
				break;
			}
			index++;
		}

		listeEtudiant.remove(index);

		// Sauvegarde dans la BDD
		promotion.setListeEtudiants(listeEtudiant);
		promotionService.modifier(promotion);

		// Renvoi de l'etudiant dans la vue seeEtudiant
		return new ModelAndView("Etudiant/seeEtudiant", "etudiantSeeCommand", etudiantService.findById(idEtudiant));
	}

	// --------------------------------------------------------//
	// --------------Binding EtudiantCours---------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/etudiant/linkEtudiantCours/{etudiantID}", method = RequestMethod.GET)
	public String toLinkEtudiantCours(@PathVariable("etudiantID") int pId, ModelMap model) {

		model.addAttribute("etudiantBindEtudiantCours", etudiantService.findById(pId));

		model.addAttribute("liste_Cours", etudiantService.findListCoursNotLinkedToEtudiant(pId));

		return "Etudiant/LinkCoursToEtudiant";
	}// end toLinkPromotion  
	
	
	/**
	 * Conversion des id des cours et des id des étudiants en objet EtudiantCours
	 * @param binder
	 */
	@InitBinder
	public void bindingPreparationEtudiantCours(WebDataBinder binder) {

		binder.registerCustomEditor(List.class, "listeEtudiantCours", new CustomCollectionEditor(List.class) {

			protected Object convertElement(Object element) {

				if (element != null) {
					String [] stringSplit = element.toString().split("-");
					
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
	 * @param etudiant
	 * @return View
	 */
	@RequestMapping(value = "/etudiant/bindCoursToEtudiant", method = RequestMethod.POST)
	public String BindCoursToEtudiant(@ModelAttribute("etudiantBindEtudiantCours") Etudiant pEtudiant) {

		//Recuperation de la liste des EtudiantCours
		List<EtudiantCours> listeEtudiantCours = pEtudiant.getListeEtudiantCours();
		
		//Ajout des EtudiantCours dans la BDD
		for (EtudiantCours etudiantCours : listeEtudiantCours) {
			etudiantCoursService.ajouter(etudiantCours);
		}
		
		return "redirect:/etudiant/see-etudiant/"+pEtudiant.getIdentifiant();
	}// end BindCoursToEtudiant()
	
	
	
	@RequestMapping(value = "/etudiants/deleteEtudiantCours", method = RequestMethod.GET)
	public ModelAndView DeleteCoursFromEtudiant(@RequestParam("idEtudiantCours") int idEtudiantCours,
			@RequestParam("idEtudiant") int idEtudiant) {
		
		etudiantCoursService.supprimer(idEtudiantCours);
		
		// Renvoi de l'etudiant dans la vue seeEtudiant
		return new ModelAndView("Etudiant/seeEtudiant", "etudiantSeeCommand", etudiantService.findById(idEtudiant));
	}
	
	@RequestMapping(value = "/etudiants/edit-form-EtudiantCours/{idEtudiantCours}", method = RequestMethod.GET)
	public ModelAndView AfficherFormEtudiantCours(@PathVariable("idEtudiantCours") int idEtudiantCours) {
				
		// Renvoi de l'etudiant dans la vue seeEtudiant
		return new ModelAndView("Etudiant/formEtudiantCours", "etudiantCoursEditCommand", etudiantCoursService.findById(idEtudiantCours));
	}
	
	@RequestMapping(value ="/etudiant/editEtudiantCours", method = RequestMethod.POST)
	public String EditEtudiantCoursFromEtudiant(@ModelAttribute("etudiantCoursEditCommand") EtudiantCours pEtudiantCours) {

		if (pEtudiantCours.getEtudiantEC()==null) {
			System.out.println("etudiantEC est null");
		}else {
			System.out.println(pEtudiantCours.getEtudiantEC().getIdentifiant());
		}
		
		
		return "redirect:/etudiant/liste";
	}// end EditEtudiantCoursFromEtudiant()

}
