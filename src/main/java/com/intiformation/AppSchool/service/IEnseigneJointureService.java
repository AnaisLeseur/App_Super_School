package com.intiformation.AppSchool.service;

import com.intiformation.AppSchool.modele.EnseigneJointure;

public interface IEnseigneJointureService extends IUniverselService<EnseigneJointure> {
	
	public boolean alreadyExist(int idEns, int idMat, int idPromo);

}
