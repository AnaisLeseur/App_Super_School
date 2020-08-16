package com.intiformation.AppSchool.dao;

import java.util.List;

import com.intiformation.AppSchool.modele.EnseigneJointure;

public interface IEnseigneJointureDAO extends IUniverselDAO<EnseigneJointure> {
	
	public boolean alreadyExist(int idEns, int idMat, int idPromo);
	
	public List<EnseigneJointure> recupAvecIdMatiere (int pIdMatiere);
	
	public List<EnseigneJointure> recupAvecIdPromo (int pIdPromo);
	
	public List<EnseigneJointure> recupAvecIdEnseignant (int pIdEnseignant);
}
