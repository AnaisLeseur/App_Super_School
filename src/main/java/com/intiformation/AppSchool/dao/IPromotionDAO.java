package com.intiformation.AppSchool.dao;

import java.util.List;

import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Promotion;

public interface IPromotionDAO extends IUniverselDAO<Promotion>{
	
	public List<Promotion> getListNotLinkedToEtudiant (int pIdEtudiant);
	
	public List<Etudiant> getListNotLinkedToPromotion (int pIdPromotion);
	
	public List<Etudiant> getListEtudiantByIdPromo (int pIdPromotion);

}//end interface
