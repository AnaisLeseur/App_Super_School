package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Administrateur;



/**
 * implémentation d'un validateur spring mvc
 * @author anais
 *
 */
@Component // déclaration de la classe comme validateur (bean spring)
public class AdministrateurValidator implements Validator {

	
	/**
	 * permet de definir l'instance à valider
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Administrateur.class.isAssignableFrom(clazz);
		}// end supports
		

		/**
		 * implementation de la logique de validation 
		 * 
		 * @param objetAValider : l'obj à valider 
		 * @param errors : pour la gestion des erreurs de validation
		 */
		@Override
		public void validate(Object objetAValider, Errors errors) {

			// 2. validation du champ motDePasse
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motDePasse", "required.motDePasse", "le champs Mot de passe est obligatoire");
			
			// 2. validation du champ nom
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "required.nomEnseignant", "le champs nom est obligatoire");
			
			// 2. validation du champ penom
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "required.prenomEnseignant", "le champs prenom est obligatoire");
			
			// 2. validation du champ email
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.emailEnseignant", "le champs email est obligatoire");
			
			
			// vérif de l'adresse
			Administrateur administrateur = (Administrateur) objetAValider;

			if (!((administrateur.getAdresse().getRue().isEmpty() && administrateur.getAdresse().getVille().isEmpty()
					&& administrateur.getAdresse().getCodePostal().isEmpty())
					|| (!administrateur.getAdresse().getRue().isEmpty() && !administrateur.getAdresse().getVille().isEmpty()
							&& !administrateur.getAdresse().getCodePostal().isEmpty()))) {

				errors.rejectValue("adresse", "notallowed.adresse", "Remplissez tout les champs de l'adresse ou aucun");

			}// end if 
		
	}// end validate
		

		public void validateUpdate(Object objetAValider, Errors errors) {

			// 2. validation du champ motDePasse
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motDePasse", "required.motDePasse", "le champs Mot de passe est obligatoire");
			
			// 2. validation du champ nom
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "required.nomEnseignant", "le champs nom est obligatoire");
			
			// 2. validation du champ penom
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "required.prenomEnseignant", "le champs prenom est obligatoire");
			
			// 2. validation du champ email
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.emailEnseignant", "le champs email est obligatoire");
			
			
			// vérif de l'adresse
			Administrateur administrateur = (Administrateur) objetAValider;

			if (!(!administrateur.getAdresse().getRue().isEmpty() && !administrateur.getAdresse().getVille().isEmpty()
							&& !administrateur.getAdresse().getCodePostal().isEmpty())) {

				errors.rejectValue("adresse", "notallowed.adresse", "Remplissez tout les champs de l'adresse ou aucun");

			}// end if 
		
	}// end validateUpdate

}// end class
