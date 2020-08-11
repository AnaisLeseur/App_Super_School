package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Promotion;

public interface IPromotionService extends IUniverselService<Promotion> {
	
	public List<Promotion> findListNotLinkedToEtudiant(int pIdEtudiant);
	
	public List<Etudiant> findListNotLinkedToPromotion (int pIdPromotion);
	
	public List<Etudiant> findListEtudiantByIdPromo (int pIdPromotion);


}//end Interface
