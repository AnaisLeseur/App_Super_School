package com.intiformation.AppSchool.validator;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Cours;

public class CoursValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Cours.class.isAssignableFrom(clazz);
	}// end support

	@Override
	public void validate(Object objetAValider, Errors errors) {

		// 1. validation du champs "libelle"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelleCours",
				"le champs est obligatoire");

		// 1. validation du champs "description"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.descriptionCours",
				"le champs est obligatoire");

		// 1. validation du champs "duree"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duree", "required.dureeCours", "le champs est obligatoire");

		// 1. validation du champs "date"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "required.dateCours", "le champs est obligatoire");

		// 2. validation du champ FKetudiant
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "FkEtudiant", "required.FkEtudiantCours",
				"le champs est obligatoire pour la FK");

		// 2. validation du champ FKMatiere
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "FkMatiere", "required.FkMatiereCours",
				"le champs est obligatoire pour la FK");

		// validation objet

		// 1 recup de l'objet a valider
		Cours cours = (Cours) objetAValider;

		// 2 validation de duree
		if (cours.getDuree() < 60) {

			// créatio d'une erreur objet
			errors.rejectValue("Duree", "notallowed.FkDureeMatiere", "La duree du cours peut être de minimum 60min");

		} // validation duree

		// validation de FKEtudiant
		if (cours.getFkEtduiant() < 0) {

			// créatio d'une erreur objet
			errors.rejectValue("FkEtudiant", "notallowed.FkEtudiantCours", "La valeur ne peut pas être négative");

		} else if (cours.getFkEtduiant() == 0) {

			errors.rejectValue("FkEtudiant", "required.FkEtudiantCours", "La valeur ne peut pas être égal à 0");

		} // end else if

		// validation de FkMatiere
		if (cours.getFkMatiere() < 0) {

			// créatio d'une erreur objet
			errors.rejectValue("FkMatiere", "notallowed.FkMatiereCours", "La valeur ne peut pas être négative");

		} else if (cours.getFkMatiere() == 0) {

			errors.rejectValue("FkMatiere", "required.FkMatiereCours", "La valeur ne peut pas être égal à 0");

		} // end else if

	}// end validate

}// end class
