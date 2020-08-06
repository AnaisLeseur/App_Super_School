package com.intiformation.AppSchool.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

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

import com.intiformation.AppSchool.cryptage.PasswordEncoderGenerator;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.service.IEtudiantService;

@Controller
public class EtudiantController {

	@Autowired
	private IEtudiantService etudiantService;
	
	@Autowired
	private ServletContext context;

	public void setEtudiantService(IEtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}
	
	public void setContext(ServletContext context) {
		this.context = context;
	}


	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, orderDateEditor);
	}

	@RequestMapping(value = "/etudiant/liste", method = RequestMethod.GET)
	public String recupererListeEtudiants(ModelMap model) {

		// Renvoi de la liste vers la vue
		model.addAttribute("attribut_listeEtudiants", etudiantService.findAll());

		// Renvoi du nom logique de la vue
		return "Etudiant/listeEtudiant";
	}// end recupererListeEmployeBdd()

	// --------------------------------------------------------//
	// -----------------Ajout Etudiant-------------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/etudiants/add-etudiant-form", method = RequestMethod.GET)
	public ModelAndView AfficherFormulaireAdd() {
		
		Etudiant etudiant =  new Etudiant();

		// return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Etudiant/addEtudiant", "etudiantAddCommand",etudiant);

	}// end AfficherFormulaire()

	@RequestMapping(value = "etudiant/add", method = RequestMethod.POST)
	public String ajouterEtudiant(@ModelAttribute("etudiantAddCommand") Etudiant pEtudiant, ModelMap model) {
		/*System.out.println(pEtudiant);
		System.out.println(pEtudiant.getNom());
		try {
			
			Part uploadedFile = pEtudiant.getUploadedPhoto();
			
			String fileName = uploadedFile.getSubmittedFileName();
			
			pEtudiant.setPhoto(fileName);
			
			InputStream imageContent = uploadedFile.getInputStream();

			File targetFile = new File(context.getRealPath("/resources/images/photos"), fileName);

			OutputStream outStream = new FileOutputStream(targetFile);
			byte[] buf = new byte[1024];
			int len;

			while ((len = imageContent.read(buf)) > 0) {
				outStream.write(buf, 0, len);
			}

			outStream.close();

		} catch (IOException ex) {
			System.out.println("erreur dans creation image");
		}*/

		
		// Partie pour cryptage MDP 
		//=========================
		
		// récup du mdp mis dans le formulaire
		String MdpNonCrypt = pEtudiant.getMotDePasse();
				
		// invocation de la methode pour le cryptage
		String MdpCrypt = PasswordEncoderGenerator.cryptageMdP(MdpNonCrypt);
		
		pEtudiant.setMotDePasse(MdpCrypt);
		
		// 1.ajout de l'employe à la bdd via la couche service
		etudiantService.ajouter(pEtudiant);

		// 2.redirection vers la methode de la recup de la liste
		return "redirect:/etudiant/liste";

	}

	// --------------------------------------------------------//
	// -------------Modification Etudiant----------------------//
	// --------------------------------------------------------//

	@RequestMapping(value = "/etudiants/update-etudiant-form/{etudiantID}", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireModification(@PathVariable("etudiantID") int pId) {

		// Return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Etudiant/updateEtudiant", "etudiantUpdateCommand", etudiantService.findById(pId));
	}
	

	@RequestMapping(value = "/etudiant/update", method = RequestMethod.POST)
	public String modifierEtudiant(@ModelAttribute("etudiantUpdateCommand") Etudiant pEtudiant) {

		// Partie pour cryptage MDP 
		//=========================
		
		// récup du mdp mis dans le formulaire
		String MdpNonCrypt = pEtudiant.getMotDePasse();
		
		// invocation de la methode pour le cryptage
		String MdpCrypt = PasswordEncoderGenerator.cryptageMdP(MdpNonCrypt);
		
		pEtudiant.setMotDePasse(MdpCrypt);

		
		// 1.Modification de l'étudiant dans la BDD
		etudiantService.modifier(pEtudiant);

		// 2.Redirection
		return "redirect:/etudiant/liste";
	}

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
	
	@RequestMapping(value = "/etudiant/see-etudiant/{etudiantID}", method = RequestMethod.GET)
	public ModelAndView ConsulterEtudiant(@PathVariable("etudiantID") int pId) {

		// Return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Etudiant/seeEtudiant", "etudiantSeeCommand", etudiantService.findById(pId));
	}
}
