package com.intiformation.AppSchool.dao;

import java.util.List;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.EtudiantCours;
import com.intiformation.AppSchool.modele.Promotion;

public interface IEtudiantDAO extends IUniverselDAO<Etudiant>{

	public Etudiant addReturnEtudiant(Etudiant pEtudiant);
	
	public List<Promotion> getListPromoByIdEtudiant(int pIdEtudiant);
	
	public List<EtudiantCours> getListEtudiantCoursByIdEtudiant(int pIdEtudiant);
	
	public List<Cours> getListCoursNotLinkedToEtudiant (int pIdEtudiant);
}
