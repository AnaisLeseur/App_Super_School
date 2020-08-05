package com.intiformation.AppSchool.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.Etudiant;

public class EtudiantValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Etudiant.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {


		// 2. validation du champ motDePasse
					ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motDePasse", "required.motDePasse", "le champs Mot de passe est obligatoire");
					
					// 2. validation du champ nom
							ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nom", "required.nomEnseignant", "le champs nom est obligatoire");
							
							// 2. validation du champ penom
							ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prenom", "required.prenomEnseignant", "le champs prenom est obligatoire");
							
							// 2. validation du champ email
							ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.emailEnseignant", "le champs email est obligatoire");
							
							// validation du champ uploadPhoto
							ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uploadedPhoto", "required.uploadedPhoto", "le champs photo est obligatoire");
		
							// validation du champ uploadPhoto
							ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateNaissance", "required.dateNaissance", "le champs date de naissance est obligatoire");
		
	}//end validate

}//end class
