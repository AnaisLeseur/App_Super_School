package com.intiformation.AppSchool.dao;

import com.intiformation.AppSchool.modele.Etudiant;

public interface IEtudiantDAO extends IUniverselDAO<Etudiant>{

	public Etudiant addReturnEtudiant(Etudiant pEtudiant);
}
