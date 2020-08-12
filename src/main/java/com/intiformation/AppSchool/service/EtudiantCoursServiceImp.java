package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IEtudiantCoursDAO;
import com.intiformation.AppSchool.modele.EtudiantCours;

@Service
public class EtudiantCoursServiceImp implements IEtudiantCoursService{
	
	@Autowired 
	private IEtudiantCoursDAO etudiantCoursDAO;
	
	/**
	 * setter pour injection par modificateur de spring
	 */
	public void setEtudiantCoursDAO(IEtudiantCoursDAO etudiantCoursDAO) {
		this.etudiantCoursDAO = etudiantCoursDAO;
	}
	

	@Override
	public void ajouter(EtudiantCours etudiantCours) {
		etudiantCoursDAO.add(etudiantCours);
	}

	@Override
	public void modifier(EtudiantCours etudiantCours) {
		etudiantCoursDAO.update(etudiantCours);
	}

	@Override
	public void supprimer(Integer idEtudiantCours) {
		etudiantCoursDAO.delete(idEtudiantCours);
	}

	@Override
	public List<EtudiantCours> findAll() {
		return etudiantCoursDAO.getAll();
	}

	@Override
	public EtudiantCours findById(Integer idEtudiantCours) {
		return etudiantCoursDAO.getById(idEtudiantCours);
	}

}
