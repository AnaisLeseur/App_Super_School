package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Promotion;

@Component // déclaration de la classe comme validateur (bean spring)
public class PromotionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Promotion.class.isAssignableFrom(clazz);
	}// end support

	@Override
	public void validate(Object target, Errors errors) {


		// 1. validation du champs "nom"
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelleMatiere", "le champs est obligatoire");
		
	}//end validate

}//end validator
