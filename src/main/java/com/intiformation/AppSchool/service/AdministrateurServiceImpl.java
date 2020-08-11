package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IAdministrateurDAO;
import com.intiformation.AppSchool.modele.Administrateur;


/**
 * implementation concrete de la couche service pour un administrateur
 *  
 * @author anais
 *
 */
@Service // déclaration de la classe Service comme bean de spring 
public class AdministrateurServiceImpl implements IAdministrateurService {
	
	// 1. déclaration de la couche DAO 
	@Autowired // injection par type du bean de la dao dans cette prop 
	private IAdministrateurDAO administrateurDAO;
	
	
	/**
	 * setteur de la DAO pour injection par modificateur de spring
	 * @param administrateurDAO
	 */
	public void setAdministrateurDAO(IAdministrateurDAO administrateurDAO) {
		this.administrateurDAO = administrateurDAO;
	}// end setter
	
	
	
	/**
	 * AJOUTER
	 */
	@Override
	public void ajouter(Administrateur pAdmin) {
		administrateurDAO.add(pAdmin);
		
	}// end ajouter
	

	/**
	 * MODIFIER
	 */
	@Override
	public void modifier(Administrateur pAdmin) {
		System.out.println("pAdmin: " + pAdmin.toString());
		administrateurDAO.update(pAdmin);
		
	}// end modifier

	
	/**
	 * SUPPRIMER
	 */
	@Override
	public void supprimer(Integer pIdAdmin) {
		administrateurDAO.delete(pIdAdmin);
		
	}// end supprimer
	

	/**
	 * FIND BY ID
	 */
	@Override
	public Administrateur findById(Integer pIdAdmin) {	
		return administrateurDAO.getById(pIdAdmin);
	}// end findById

	
	
	/**
	 * FIND ALL
	 */
	@Override
	public List<Administrateur> findAll() {
		return administrateurDAO.getAll();
	}// end findAll

}// end class
