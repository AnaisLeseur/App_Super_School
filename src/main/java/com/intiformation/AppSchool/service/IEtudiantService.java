package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Promotion;

public interface IEtudiantService extends IUniverselService<Etudiant>{
	
	public Etudiant ajouterReturnEtudiant(Etudiant pEtudiant);
	
	public List<Promotion> findListPromoByIdEtudiant(int pIdEtudiant);
	
	public List<Cours> findListCoursNotLinkedToEtudiant (int pIdEtudiant);

}
