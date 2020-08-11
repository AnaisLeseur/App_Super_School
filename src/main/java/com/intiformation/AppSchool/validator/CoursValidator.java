package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Cours;

@Component // declaration de la class comme validateur (bean spring)
public class CoursValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Cours.class.isAssignableFrom(clazz);
	}// end support

	@Override
	public void validate(Object objetAValider, Errors errors) {

		// 1. validation du champs "libelle"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelle", "le champs est obligatoire");

		// 1. validation du champs "description"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description",
				"le champs est obligatoire");

		// 1. validation du champs "duree"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "duree", "required.duree", "le champs est obligatoire");

		// 1. validation du champs "date"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "required.date", "le champs est obligatoire");

		// validation objet

		// 1 recup de l'objet a valider
		Cours cours = (Cours) objetAValider;

		// 2 validation de duree
		if (cours.getDuree() < 60) {

			// créatio d'une erreur objet
			errors.rejectValue("duree", "notallowed.duree", "La duree du cours peut être de minimum 60min");

		} // validation duree

	}// end validate

}// end class
