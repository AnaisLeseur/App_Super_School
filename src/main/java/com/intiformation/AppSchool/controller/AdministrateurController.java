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

import com.intiformation.AppSchool.cryptage.PasswordEncoderGenerator;
import com.intiformation.AppSchool.modele.Administrateur;
import com.intiformation.AppSchool.service.IAdministrateurService;
import com.intiformation.AppSchool.validator.AdministrateurValidator;


/**
 * implementation d'un controleur spring mvc pour la gestion des administrateurs.
 * Gestion opération CRUD de l'administrateur
 * 
 * @author anais
 *
 */
@Controller // déclaration de la classe comme bean spring de type controleur spring mvc 
public class AdministrateurController {
	
	// déclaration service
	@Autowired // injection du bean de la couche service dans cette prop 'adminService'
	private IAdministrateurService adminService;

	
	// déclaration du validateur
	@Autowired
	private AdministrateurValidator adminValidator; 
	
	
	/**
	 * setter de la couche service pour injection spring 
	 * 
	 * @param adminService
	 */
	@Autowired
	public AdministrateurController(IAdministrateurService adminService) {
		this.adminService = adminService;
	}


	/**
	 * setter pour le validateur pour injection spring 
	 * 
	 * @param adminValidator
	 */
	public void setAdminValidator(AdministrateurValidator adminValidator) {
		this.adminValidator = adminValidator;
	}
	
	

	//----------------- METHODES --------------------
	// Meths gestionnaires du controleur 
	
	/**
	 * methode pour la recup de la liste des administrateurs de la bdd via le service 
	 * cette meth est invoquée via une rqt http en get  

	 * @param model : modele de données à renvoyer vers la vue
	 * @return: le nom logique de la vue 
	 */
	@RequestMapping(value="administrateurs/liste", method=RequestMethod.GET)
	public String recupererListeAdminBdd(ModelMap model) {
		
		// 1. récup de la liste des admins dans la bdd via le service 
		List<Administrateur> listeAdminsBdd = adminService.findAll();
		
		// 2. renvoie de la liste vers la vue via l'objet 'model' (le param) de type ModelMap
		model.addAttribute("attribut_liste_admins", listeAdminsBdd);
		
		// 3. renvoi du nom logique de la vue 
		/**
		 * résolution de la vue par le viewResolver:
		 */
		return "Personnel/liste-administrateurs";
		
	}// end recupererListeAdminBdd	
	
	
	
	
	/**
	 * permet de supprimer un admin dans la bdd avec son id via le service 
	 * 
	 * @return : le nom logique de la vue 
	 * 
	 */
	@RequestMapping(value= {"/administrateurs/delete/{adminId}"}, method=RequestMethod.GET)
	public String supprimerAdministrateurBdd(@PathVariable("adminId") int pIdAdmin, ModelMap model) {
		
		// 1. suppression de l'admin dans la bdd via le service 
		adminService.supprimer(pIdAdmin);
	
		//  redirection vers l'url '/administrateurs/liste' pour invoquer la methode 'recupererListeAdminBdd' 
		return "redirect:/administrateurs/liste";
	
	}// end supprimerAdministrateurBdd
	
	
	/**
	 * permet d'afficher le formulaire d'ajout pour un admin.
	 * meth invoquée suite au click du lien 'ajouter un admin' de 'liste-administrateurs.jsp'
	 * @return: le nom logique de la vue 
	 */
	@RequestMapping(value="/administrateurs/add-admin-form", method=RequestMethod.GET)
	public ModelAndView afficherFormAjoutAdmin() {
		
		// 1. definition d'un objet de commande qui va permettre la liaison avec les champs
		// 1.1 l'object de commande => c'est un objet Administrateur vide 
		Administrateur admin = new Administrateur();
		
		// 1.2 affectation d'un nom à l'objet de commande (par defaut : command)
		String nomObjCommande = "adminCommand";
		
		// 2. envoi de l'objet de commande vers la vue (page du formulaire)
		Map<String, Object> dataCommand = new HashMap<>();
		dataCommand.put(nomObjCommande, admin);
		
		// 3. definition du nom logique de la vu
		/**
		 * résolution de la vue par le viewResolver:
		 */
		String viewName = "Personnel/ajouter-admin";
		
		// 4. envoi de l'objet ModelAndView vers la servlet DispatcherServlet
		return new ModelAndView(viewName, dataCommand);
						
	}// end afficherFormAjoutAdmin()
	
	
	/**
	 * methode pour ajouter un admin dans la bdd .
	 * meth invoquée à la sousmission du formulaire d'ajout dans 'ajouter-admin.jsp".
	 * meth invoquée avec une Rqt http en post et l'url '/administrateurs/add'.
	 * meth récupère l'objet de commande 'adminCommand' lié au formulaire via @ModelAttribute
	 * 	et le met dans pAdmin
	 * 
	 * @param resultatValidation : contient le résultat du process de la validation 
	 * @return: le nom logique de la vue (redirection)
	 */
	@RequestMapping(value="/administrateurs/add", method=RequestMethod.POST)
	public String ajouterAdminBdd(@ModelAttribute("adminCommand") @Validated Administrateur pAdmin, 
									BindingResult resultatValidation) {
		
		// application du validateur sur l'objet pAdmin
		adminValidator.validate(pAdmin, resultatValidation);
		
		if (resultatValidation.hasErrors()) {
			// si on entre dans le IF => la validation a détecté des erreurs
			
			// => redirection vers la page du formulaire d'ajout : 'Personnel/ajouter-admin.jsp"
			return "Personnel/ajouter-admin"; // nom logique de la vue 
			
		} else {
			// la validation n'a pas détecté d'erreurs
			
			// récup du mdp mis dans le formulaire
			String MdpNonCrypt = pAdmin.getMotDePasse();
			
			// invocation de la methode pour le cryptage
			String MdpCrypt = PasswordEncoderGenerator.cryptageMdP(MdpNonCrypt);
			
			pAdmin.setMotDePasse(MdpCrypt);

			// 1. ajout de l'admin à la bdd via la couche service 
			adminService.ajouter(pAdmin);
		
			// 2. redirection vers la page liste-administrateurs.jsp
			return "redirect:/administrateurs/liste";

		}// end else
	}// end ajouterAdminBdd
	
	
	/**
	 * permet d'afficher le formulaire de modification d'un admin.
	 * meth invoquée suite au click du lien 'modifier' de 'liste-administrateurs.jsp'
	 * meth invoquée avec une rqt http en get
	 * 
	 * @return: le nom logique de la vue 
	 */
	@RequestMapping(value="/administrateurs/update-admin-form", method=RequestMethod.GET)
	public ModelAndView afficherFormModificationAdmin(@RequestParam("idAdmin") int pIdAdmin) {
		
		// 1. récup de l'admin à modifier via son id dans la bdd
		Administrateur adminAModifier = adminService.findById(pIdAdmin);
		
		// 2. definition du model de données (l'objet de commande nommé ''adminModifCommand') 
		//		+ definition du nom logique de la vue 'modifier-admin' + ajout du modele et du nom dans un objet ModelAndView
		return new ModelAndView("Personnel/modifier-admin", "adminModifCommand", adminAModifier);
		
	}// end afficherFormModificationAdmin
	
	
	
	/**
	 * methode pour modifier un admin dans la bdd .
	 * meth invoquée à la sousmission du formulaire de modification de la page 'modifier-admin.jsp".
	 * meth invoquée avec une Rqt http en post et l'url '/administrateurs/update'.
	 * meth récupère l'objet de commande 'adminModifCommand' lié au formulaire via @ModelAttribute
	 * 	et le met dans pAdminToUpdate
	 * @return: le nom logique de la vue (redirection)
	 */
	@RequestMapping(value="/administrateurs/update", method=RequestMethod.POST)
	public String modifierAdminBdd(@ModelAttribute("adminModifCommand") @Validated Administrateur pAdminToUpdate, 
									BindingResult bindingResult) {
		
		adminValidator.validate(pAdminToUpdate, bindingResult);
		
		if (bindingResult.hasErrors()) {

			return "Personnel/modifier-admin";

		} else {
			
		//Si  !( MDP BDD = MDP input ) alors cryptage du nouveau MDP
			System.out.println("pAdminToUpdate.getIdentifiant():" + pAdminToUpdate.getIdentifiant());
			System.out.println("pAdminToUpdate.getIdentifiant().getMotDePasse():" + adminService.findById(pAdminToUpdate.getIdentifiant()).getMotDePasse());
			System.out.println("equals(pAdminToUpdate.getMotDePasse():" + pAdminToUpdate.getMotDePasse());
		if(!(adminService.findById(pAdminToUpdate.getIdentifiant()).getMotDePasse().equals(pAdminToUpdate.getMotDePasse()))) {
		
			// récup du mdp mis dans le formulaire
			String MdpNonCryptToUpdate = pAdminToUpdate.getMotDePasse();
			
			// invocation de la methode pour le cryptage
			String MdpCryptToUpdate = PasswordEncoderGenerator.cryptageMdP(MdpNonCryptToUpdate);
			
			pAdminToUpdate.setMotDePasse(MdpCryptToUpdate);
			
			System.out.println("pAdminToUpdate.setMotDePasse(MdpCryptToUpdate);" + pAdminToUpdate.toString());
		}// end if
		
		// 1. modif de l'admin dans la bdd via service
		adminService.modifier(pAdminToUpdate);
		
		// 3. renvoi du nom de la vue logique de la vue :
		return "redirect:/administrateurs/liste";
		}// end else
	}// end modifierAdminBdd
	
	
	
	/**
	 * methode pour voir un admin dans la bdd..
	 * meth invoquée au clic sur "la loupe" => voir les détails de l'admin
	 * meth récupère l'objet de commande 'adminVoirCommand'
	 * @param pIdAdmin
	 * @return ModelAndView : le nom logique de la vue et le model Admin sélectionné avec l'Id 
	 */
	@RequestMapping(value = "/administrateurs/see-admin/{adminId}", method = RequestMethod.GET)
	public ModelAndView ConsulterAdmin(@PathVariable("adminId") int pIdAdmin) {

		// Return new ModelAndView(viewName, modelName, modelObject)
		return new ModelAndView("Personnel/voir-admin", "adminVoirCommand", adminService.findById(pIdAdmin));
	}// end ConsulterAdmin

}// end AdministrateurController
