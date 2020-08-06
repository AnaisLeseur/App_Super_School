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

import com.intiformation.AppSchool.modele.Matiere;
import com.intiformation.AppSchool.modele.Promotion;
import com.intiformation.AppSchool.service.IPromotionService;
import com.intiformation.AppSchool.validator.PromotionValidator;



@Controller // declaration de la classe comme controller spring mvc
public class PromotionController {

	// declaration de la couche service
			@Autowired
			private IPromotionService promotionService;

			@Autowired
			private PromotionValidator promotionValidator;

	// setter
			public void setPromotionService(IPromotionService promotionService) {
				this.promotionService = promotionService;
			}

			public void setPromotionValidator(PromotionValidator promotionValidator) {
				this.promotionValidator = promotionValidator;
			}
			
			//-----------methode gestionnaire du controlleur -------------
			@RequestMapping(value="/promotion/liste" , method=RequestMethod.GET)
			public String recupererListePromotionBDD(ModelMap model) {
				
				// 1. recup de la liste des employés dans la bdd via le service
				List<Promotion> listePromotionBdd = promotionService.findAll();
				
				// 2. on utilise model pour renvoyer la liste vers la vue 
				model.addAttribute("attribut_liste_promotion", listePromotionBdd);
				
				// 3 renvoi du nom logique de la vue
				/**
				 * > resolution de la vue par le viewResolver :
				 * 
				 *     liste-Matiere ====> WEB-INF/views/liste-Matiere.jsp
				 */
				return "liste-promotion";
				
			}//end recupListe
			
			/**
			 * permet de supprimer
			 * @return
			 * accolade dans value si on eut definir pmlsieur url
			 */
			@RequestMapping(value= {"/promotion/delete/{promotion-id}" , "/promotion/remove/{promotion-id}" }, method=RequestMethod.GET)
			public String supprimerPromotion(@PathVariable("promotion-id") int pIdPromotion, ModelMap model) {
				
				// 1 . suppresion de matiere dans la bdd via le service
				
				promotionService.supprimer(pIdPromotion);
				
				//2 . recup de la nouvelle liste des employe
				List<Promotion> listePromotionBdd = promotionService.findAll();
				
				// 4bis ou 4
				//3 . envoie des données à afficher dans la vue
				model.addAttribute("attribut_liste_promotion", listePromotionBdd);
				
				//4 bis
				//return "liste-matiere";
				
				// 4 redirection vers l'url /matiere/liste pour invoquer la méthode recupererListeEmployeeBdd
				// et nous rediriger vers liste-matiere.jsp
				
				return "redirect:/promotion/liste";
				
			}// end suppr
			
			/**
			 * permet d'afficher le formulaire d'ajout d'un employé
			 * cette methode est invoquée suite au click du lien "Ajout d'un employé"
			 * de liste-employes.jsp /employes/add-employe-form
			 * @return
			 */
			@RequestMapping(value="/promotion/add-promotion-form", method=RequestMethod.GET)
			// ou @GetMapping au lieu du method = .... 
			public ModelAndView afficherFormulaireAjout() {
				
				//1 definition d'un objet de commmande qui va permettre la liaision avec les champs du formulaire
				
				//1.1 l'objet de commande (c'est un objet employé vide)
				Promotion promotion = new Promotion();
				
				// 1.2 affectation d'un nomà l'objet de commande (par défaut : command)
				String nomObjetCommande = "promotionCommand";
				
				// 2. envoie de l'objet de commande vers la vue (page du formulaire)
				Map<String, Object> dataCommand = new HashMap<>();
				dataCommand.put(nomObjetCommande, promotion);
				
				//3. def du nom logique de la vue 
				/**
				 * > resolution de la vue par le view resolveur :
				 * 
				 * ajout-matiere ==========> /WEB-INF/views/ajout-matiere
				 */
				String viewname = "ajouter-promotion";
				
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
			@RequestMapping(value="/promotion/add", method=RequestMethod.POST)
			public String ajouterPromotionBDD(@ModelAttribute("promotionCommand") @Validated Promotion pPromotion,
					                        ModelMap model, BindingResult resultatValidation ) {
				
				//validation de l'objet pEmploye
				promotionValidator.validate(pPromotion, resultatValidation);
				
				//validation
				if (resultatValidation.hasErrors()) {
					
					// la validation a détécté des erreurs
					//-> redirection vers la page du formulaire ajouter-employe
					return "ajouter-promotion"; // nom de la view
					
				} else {
					
					// la validation n'a pas détécté d'erreur

				//1 ajout de l'employé à la bdd via le service via la couche service
				promotionService.ajouter(pPromotion);;
				
				//2. redirection vers la page liste-promotion.jsp
				
				//2.1. recup nouvelle liste + envoie de la liste
				 model.addAttribute("attribut_liste_promotion", promotionService.findAll())   ;
				
				
				return "redirect:/promotion/liste";
				}//end else
				
				
				
			}//end ajouter promotionBDD
			
			
			/**
			 *
			 * permet d'afficher le formulaire de modif d'un employé
			 * cette methode est invoquée suite au click du lien "Modif d'un employé"
			 * de liste-employes.jsp /employes/update-employe-form?idemploye=1
			 * @return
			 */
			@RequestMapping(value="/promotion/update-promotion-form" , method=RequestMethod.GET)
			public ModelAndView afficherFormulaireModificationPromotion(@RequestParam("idpromotion") int pPromotionId) {
				
				// 1 recup de la promotion à modifier via son id dans la bdd
				Promotion promotionAModifier = promotionService.findById(pPromotionId);
				
				// 2. def du model de donnée (objet de commande nommé "employeModifCommand") + def du nom logique de la vue 
				// + => ajout du modele et du nom dans l'objet ModelAndView
				
				return new ModelAndView("modifier-promotion", "promotionModifCommand", promotionAModifier);
				
				/**
				 * modifier-employe = /WEB-INF/views/modifier-employe.jsp
				 * 
				 * 
				 */
				
			}//affichferFormulaireModificationPromotion
			
			/**
			 * permet de modifier un employé dans la bdd
			 * cette methode est invoqué à la soumission du formulaire
			 * ajout dans modifier-employe.jsp
			 * cette methode est invoquée avec une requete http en post et l'url 
			 * "/employes/update"
			 * cette methode recupere l'objet de commande qui s'appelle "employeModifCommand" lié au formulaire
			 * @return nom logique de la vue
			 */
			@RequestMapping(value="/promotion/update", method=RequestMethod.POST)
			public String ModifierPromotionBDD(@ModelAttribute("promotionModifCommand") Promotion pModifpromotion, ModelMap model) {
				
				// 1. modif dans la bdd via la couche service
				promotionService.modifier(pModifpromotion);;
				
				//2 recup de la nouelle liste employé
				model.addAttribute("attribut_liste_promotion", promotionService.findAll());
				
				return "redirect:/promotion/liste";
			}//end modifier
			
}//end class
