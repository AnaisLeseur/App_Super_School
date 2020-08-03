package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IEnseignantDAO;
import com.intiformation.AppSchool.modele.Enseignant;


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
	public void ajoutEnseignant(Enseignant pEnseignant) {
		enseignantDAO.add(pEnseignant);
		
	}// end ajouter

	
	/**
	 * MODIFIER
	 */
	@Override
	public void modifierEnseignant(Enseignant pEnseignant) {
		enseignantDAO.update(pEnseignant);
		
	}// end modifier

	
	/**
	 * SUPPRIMER
	 */	
	@Override
	public void supprimerEnseignant(int pIdEnseignant) {
		enseignantDAO.delete(pIdEnseignant);
		
	}// end supprimerEnseignant
	
	/**
	 * FIND BY ID
	 */
	@Override
	public Enseignant findEnseignantById(int pIdEnseignant) {
		return enseignantDAO.getById(pIdEnseignant);
	}// end findEnseignantById
	
	/**
	 * FIND ALL
	 */
	@Override
	public List<Enseignant> findAllEnseignant() {
		return enseignantDAO.getAll();
	}// end findAllEnseignant


}// end class
