package com.intiformation.AppSchool.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Cours;

@Component //declaration de la class comme validateur (bean spring)
public class CoursValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Cours.class.isAssignableFrom(clazz);
	}// end support

	@Override
	public void validate(Object objetAValider, Errors errors) {

		// 1. validation du champs "libelle"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelle",
				"le champs est obligatoire");

		// 1. validation du champs "description"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description",
				"le champs est obligatoire");

		// 1. validation du champs "duree"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duree", "required.duree", "le champs est obligatoire");

		// 1. validation du champs "date"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "required.date", "le champs est obligatoire");

		// 2. validation du champ FKetudiant
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fkEtudiant", "required.fkEtudiant",
				"le champs est obligatoire pour la FK");

		// 2. validation du champ FKMatiere
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fkMatiere", "required.fkMatiere",
				"le champs est obligatoire pour la FK");

		// validation objet

		// 1 recup de l'objet a valider
		Cours cours = (Cours) objetAValider;

		// 2 validation de duree
		if (cours.getDuree() < 60) {

			// créatio d'une erreur objet
			errors.rejectValue("duree", "notallowed.duree", "La duree du cours peut être de minimum 60min");

		} // validation duree

		// validation de FKEtudiant
		if (cours.getFkEtudiant() < 0) {

			// créatio d'une erreur objet
			errors.rejectValue("fkEtudiant", "notallowed.fkEtudiant", "La valeur ne peut pas être négative");

		} else if (cours.getFkEtudiant() == 0) {

			errors.rejectValue("fkEtudiant", "required.fkEtudiant", "La valeur ne peut pas être égal à 0");

		} // end else if

		// validation de FkMatiere
		if (cours.getFkMatiere() < 0) {

			// créatio d'une erreur objet
			errors.rejectValue("fkMatiere", "notallowed.fkMatiere", "La valeur ne peut pas être négative");

		} else if (cours.getFkMatiere() == 0) {

			errors.rejectValue("fkMatiere", "required.fkMatiere", "La valeur ne peut pas être égal à 0");

		} // end else if

	}// end validate

}// end class
