package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



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
		return false;
	}// end supports
	

	/**
	 * implementation de la logique de validation 
	 * 
	 * @param objetAValider : l'obj à valider 
	 * @param errors : pour la gestion des erreurs de validation
	 */
	@Override
	public void validate(Object objetAValider, Errors errors) {
		// TODO Auto-generated method stub
		
	}// end validate

}// end class
