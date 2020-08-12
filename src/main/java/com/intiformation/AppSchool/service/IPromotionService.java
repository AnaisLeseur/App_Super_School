package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Promotion;

public interface IPromotionService extends IUniverselService<Promotion> {
	
	public List<Promotion> findListNotLinkedToEtudiant(int pIdEtudiant);
	
	public List<Etudiant> findListNotLinkedToPromotion (int pIdPromotion);
	
	public List<Etudiant> findListEtudiantByIdPromo (int pIdPromotion);
	
public List<Promotion> findListNotLinkedToCours(int pIdCours);
	
	public List<Cours> findListNotLinkedToPromotionCours (int pIdPromotion);
	
	public List<Cours> findListCoursByIdPromo (int pIdPromotion);


}//end Interface
