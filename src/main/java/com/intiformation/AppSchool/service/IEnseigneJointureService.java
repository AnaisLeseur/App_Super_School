package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.EnseigneJointure;

public interface IEnseigneJointureService extends IUniverselService<EnseigneJointure> {
	
	public boolean alreadyExist(int idEns, int idMat, int idPromo);
	
	public List<EnseigneJointure> recupEJAvecIdMatiere (int pIdMatiere);
	
	public List<EnseigneJointure> recupEJAvecIdPromo (int pIdPromo);
	
	public List<EnseigneJointure> recupEJAvecIdEnseignant (int pIdEnseignant);
	

}
