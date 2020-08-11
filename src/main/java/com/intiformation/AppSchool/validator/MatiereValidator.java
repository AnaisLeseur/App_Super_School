package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Matiere;

@Component // declaration de la class comme validateur (bean spring)
public class MatiereValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Matiere.class.isAssignableFrom(clazz);
	}// end support

	@Override
	public void validate(Object objetAValider, Errors errors) {
		// TODO Auto-generated method stub
		// 1. validation du champs "nom"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelleMatiere",
				"le champs est obligatoire");


	}// end validate

}// end class
