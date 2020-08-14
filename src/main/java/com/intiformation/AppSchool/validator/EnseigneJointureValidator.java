package com.intiformation.AppSchool.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.intiformation.AppSchool.modele.EnseigneJointure;
import com.intiformation.AppSchool.service.IEnseigneJointureService;

@Component
public class EnseigneJointureValidator implements Validator{

	@Autowired
	private IEnseigneJointureService ejService;
	
	public void setEjService(IEnseigneJointureService ejService) {
		this.ejService = ejService;
	}
	

	@Override
	public boolean supports(Class<?> clazz) {
		return EnseigneJointure.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		EnseigneJointure ej = (EnseigneJointure) target;
		
		int idEns = ej.getEnseignantEJ().getIdentifiant();
		int idMat = ej.getMatiereEJ().getIdMatiere();
		int idPromo = ej.getPromotionEJ().getIdPromotion();
		
		if ((idEns==0 && (idMat==0 || idPromo==0))||(idMat==0 &&(idEns==0 || idPromo==0))||(idPromo==0 &&(idMat==0 || idEns==0))) {
			errors.reject("notallowed.iEnseigneJointure", "Veuillez sélectionner au moins deux entités à lier");
		}
		
		if (ejService.alreadyExist(idEns, idMat, idPromo)) {
			errors.reject("notallowed.iEnseigneJointure", "Cette association existe déjà");
		}
		
	}

}
