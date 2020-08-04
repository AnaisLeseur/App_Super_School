package com.intiformation.AppSchool.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Matiere;

@Component //declaration de la class comme validateur (bean spring)
public class MatiereValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Matiere.class.isAssignableFrom(clazz);
	}//end support

	@Override
	public void validate(Object objetAValider, Errors errors) {
		// TODO Auto-generated method stub
		// 1. validation du champs "nom"
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "libelle", "required.libelleMatiere", "le champs est obligatoire");
				
				// 2. validation du champ fonction
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "FkEnseignant", "required.FkEnseignantMatiere", "le champs est obligatoire pour la FK");
				
				// validation objet
				
				//1 recup de l'objet a valider
				Matiere matiere = (Matiere) objetAValider;
				
				//2 validation du salaire
				if (matiere.getFkEnseignant() < 0) {
					
					// créatio d'une erreur objet
					errors.rejectValue("FkEnseignant", "notallowed.FkEnseignantMatiere", "La valeur ne peut pas être négative");
					
				}else if (matiere.getFkEnseignant() == 0) {
					
					errors.rejectValue("FkEnseignant", "required.FkEnseignantMatiere", "La valeur ne peut pas être égal à 0");

				}// end else if
		
		
	}//end validate

}//end class
