package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IEnseignantDAO;
import com.intiformation.AppSchool.modele.Enseignant;
import com.intiformation.AppSchool.modele.Etudiant;


/**
 * implementation concrete de la couche service pour un enseignant
 *  
 * @author anais
 *
 */
@Service // déclaration de la classe Service comme bean de spring 
public class EnseignantServiceImpl implements IEnseignantService{
	
	// 1. déclaration de la couche DAO 
	@Autowired // injection par type du bean de la dao dans cette prop 
	private IEnseignantDAO enseignantDAO;
	
	/**
	 * setteur de la DAO pour injection par modificateur de spring
	 * @param enseignantDAO
	 */
	public void setEnseignantDAO(IEnseignantDAO enseignantDAO) {
		this.enseignantDAO = enseignantDAO;
	}// end setter

	

	/**
	 * AJOUTER
	 */
	@Override
	public void ajouter(Enseignant pEnseignant) {
		enseignantDAO.add(pEnseignant);
		
	}// end ajouter

	
	/**
	 * MODIFIER
	 */
	@Override
	public void modifier(Enseignant pEnseignant) {
		enseignantDAO.update(pEnseignant);
		
	}// end modifier

	
	/**
	 * SUPPRIMER
	 */	
	@Override
	public void supprimer(Integer pIdEnseignant) {
		enseignantDAO.delete(pIdEnseignant);
		
	}// end supprimer
	
	/**
	 * FIND BY ID
	 */
	@Override
	public Enseignant findById(Integer pIdEnseignant) {
		return enseignantDAO.getById(pIdEnseignant);
	}// end findById
	
	/**
	 * FIND ALL
	 */
	@Override
	public List<Enseignant> findAll() {
		return enseignantDAO.getAll();
	}// end findAll



	@Override
	public List<Etudiant> findListEtudiantByIdEnseignant(int idEnseignant) {
		return enseignantDAO.getListEtudiantByIdEnseignant(idEnseignant);
	}


}// end class
