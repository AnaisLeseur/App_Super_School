package com.intiformation.AppSchool.dao;

import java.util.List;

import com.intiformation.AppSchool.modele.Promotion;

public interface IPromotionDAO extends IUniverselDAO<Promotion>{
	
	public List<Promotion> getListNotLinkedToEtudiant (int pIdEtudiant);

}//end interface
