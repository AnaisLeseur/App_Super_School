package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Aide;

@Component //declaration de la class comme validateur (bean spring)
public class AideValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Aide.class.isAssignableFrom(clazz);
	}//end support

	@Override
	public void validate(Object target, Errors errors) {


		// 1. validation du champs "titre"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contenu", "required.contenu", "le champs est obligatoire");

		// 1. validation du champs "titre"
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titre", "required.titre", "le champs est obligatoire");

		
	}//end validate

}//end validator
