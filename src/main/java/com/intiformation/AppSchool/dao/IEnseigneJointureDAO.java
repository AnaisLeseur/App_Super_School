package com.intiformation.AppSchool.dao;

import com.intiformation.AppSchool.modele.EnseigneJointure;

public interface IEnseigneJointureDAO extends IUniverselDAO<EnseigneJointure> {
	
	public boolean alreadyExist(int idEns, int idMat, int idPromo);

}
