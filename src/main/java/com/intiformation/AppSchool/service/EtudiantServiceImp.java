package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IEtudiantDAO;
import com.intiformation.AppSchool.modele.Etudiant;

@Service
public class EtudiantServiceImp implements IEtudiantService{
	
	@Autowired 
	private IEtudiantDAO etudiantDAO;
	/**
	 * setter pour injection par modificateur de spring
	 */
	public void setEtudiantDAO(IEtudiantDAO etudiantDAO) {
		this.etudiantDAO = etudiantDAO;
	}
	
	

	@Override
	public void ajouter(Etudiant pEtudiant) {
		etudiantDAO.add(pEtudiant);
	}

	@Override
	public void modifier(Etudiant pEtudiant) {
		etudiantDAO.update(pEtudiant);
	}

	@Override
	public void supprimer(Integer idEtudiant) {
		etudiantDAO.delete(idEtudiant);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDAO.getAll();
	}

	@Override
	public Etudiant findById(Integer idEtudiant) {
		return etudiantDAO.getById(idEtudiant);
	}

}//end class