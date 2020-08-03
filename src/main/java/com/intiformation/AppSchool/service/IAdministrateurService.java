package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Administrateur;

/**
 * interface de la couche service pour l'administrateur
 *
 * @author anais
 *
 */
public interface IAdministrateurService {
	
	public void ajoutAdmin(Administrateur pAdmin);
	
	public void modifierAdmin(Administrateur pAdmin);
	
	public void supprimerAdmin(int pIdAdmin);
	
	public Administrateur findAdminById(int pIdAdmin);
	
	public List<Administrateur> findAllAdmin();

}// end interface
