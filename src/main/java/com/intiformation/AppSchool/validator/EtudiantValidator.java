package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Etudiant;

@Component
public class EtudiantValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Etudiant.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	}

	public void validateAdd(Object target, Errors errors) {

		// 2. validation du champ motDePasse
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motDePasse", "required.motDePasse",
				"le champs Mot de passe est obligatoire");

		// 2. validation du champ nom
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "required.nomEnseignant",
				"le champs nom est obligatoire");

		// 2. validation du champ penom
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "required.prenomEnseignant",
				"le champs prenom est obligatoire");

		// 2. validation du champ email
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.emailEnseignant",
				"le champs email est obligatoire");

		// validation du champ dateNaissance
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", "required.dateNaissance",
				"le champs date de naissance est obligatoire");

		// validation du champ uploadedPhoto
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uploadedPhoto", "required.uploadedPhoto",
				"le champs photo est obligatoire");

		Etudiant etudiant = (Etudiant) target;

		if (!((etudiant.getAdresse().getRue().isEmpty() && etudiant.getAdresse().getVille().isEmpty()
				&& etudiant.getAdresse().getCodePostal().isEmpty())
				|| (!etudiant.getAdresse().getRue().isEmpty() && !etudiant.getAdresse().getVille().isEmpty()
						&& !etudiant.getAdresse().getCodePostal().isEmpty()))) {

			errors.rejectValue("adresse", "notallowed.adresse", "Remplissez tout les champs de l'adresse ou aucun");

		}
	}// end validateAdd

	public void validateUpdate(Object target, Errors errors) {

		// 2. validation du champ motDePasse
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motDePasse", "required.motDePasse",
				"le champs Mot de passe est obligatoire");

		// 2. validation du champ nom
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "required.nomEnseignant",
				"le champs nom est obligatoire");

		// 2. validation du champ penom
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "required.prenomEnseignant",
				"le champs prenom est obligatoire");

		// 2. validation du champ email
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.emailEnseignant",
				"le champs email est obligatoire");

		// validation du champ dateNaissance
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", "required.dateNaissance",
				"le champs date de naissance est obligatoire");

		Etudiant etudiant = (Etudiant) target;

		if (!(!etudiant.getAdresse().getRue().isEmpty() && !etudiant.getAdresse().getVille().isEmpty()
				&& !etudiant.getAdresse().getCodePostal().isEmpty())) {

			errors.rejectValue("adresse", "notallowed.adresse", "Remplissez tout les champs de l'adresse ou aucun");

		}

	}// end validateUpdate

}// end class
