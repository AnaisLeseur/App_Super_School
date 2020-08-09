package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Promotion;

public interface IPromotionService extends IUniverselService<Promotion> {
	
	public List<Promotion> findListNotLinkedToEtudiant(int pIdEtudiant);

}//end Interface
