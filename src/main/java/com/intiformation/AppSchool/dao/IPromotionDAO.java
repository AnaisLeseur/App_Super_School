package com.intiformation.AppSchool.dao;

import java.util.List;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Promotion;

public interface IPromotionDAO extends IUniverselDAO<Promotion>{
	
	public List<Promotion> getListNotLinkedToEtudiant (int pIdEtudiant);
	
	public List<Etudiant> getListNotLinkedToPromotion (int pIdPromotion);
	
	public List<Etudiant> getListEtudiantByIdPromo (int pIdPromotion);
	
	public List<Promotion> getListNotLinkedToCours (int pIdCours);
	
	public List<Cours> getListNotLinkedToPromotionCours (int pIdPromotion);
	
	public List<Cours> getListCoursByIdPromo (int pIdPromotion);

}//end interface
