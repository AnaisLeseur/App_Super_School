package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IEnseigneJointureDAO;
import com.intiformation.AppSchool.modele.EnseigneJointure;

@Service
public class EnseigneJointureServiceImp implements IEnseigneJointureService{
	
	@Autowired
	private IEnseigneJointureDAO enseigneJointureDAO;
	
	public void setEnseigneJointureDAO(IEnseigneJointureDAO enseigneJointureDAO) {
		this.enseigneJointureDAO = enseigneJointureDAO;
	}

	@Override
	public void ajouter(EnseigneJointure enseigneJointure) {
		enseigneJointureDAO.add(enseigneJointure);
	}

	@Override
	public void modifier(EnseigneJointure enseigneJointure) {
		enseigneJointureDAO.update(enseigneJointure);
	}

	@Override
	public void supprimer(Integer idEnseigneJointure) {
		enseigneJointureDAO.delete(idEnseigneJointure);
	}

	@Override
	public List<EnseigneJointure> findAll() {
		return enseigneJointureDAO.getAll();
	}

	@Override
	public EnseigneJointure findById(Integer idEnseigneJointure) {
		return enseigneJointureDAO.getById(idEnseigneJointure);
	}

	@Override
	public boolean alreadyExist(int idEns, int idMat, int idPromo) {
		return enseigneJointureDAO.alreadyExist(idEns, idMat, idPromo);
	}

	@Override
	public List<EnseigneJointure> recupEJAvecIdMatiere(int pIdMatiere) {
		return enseigneJointureDAO.recupAvecIdMatiere(pIdMatiere);
	}

	@Override
	public List<EnseigneJointure> recupEJAvecIdPromo(int pIdPromo) {
		return enseigneJointureDAO.recupAvecIdPromo(pIdPromo);
	}

	@Override
	public List<EnseigneJointure> recupEJAvecIdEnseignant(int pIdEnseignant) {
		return enseigneJointureDAO.recupAvecIdEnseignant(pIdEnseignant);
	}

}
