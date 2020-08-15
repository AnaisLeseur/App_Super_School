package com.intiformation.AppSchool.dao;

import com.intiformation.AppSchool.modele.Administrateur;
import com.intiformation.AppSchool.modele.Personne;

/**
 * Interface DAO spécifique à un administrateur
 * Hérite de IUniverselDAO
 * 
 * @author anais
 *
 */
public interface IAdministrateurDAO extends IUniverselDAO<Administrateur> {
	
	/*__________ Méthodés spécifiques à l'adminitrateur __________*/ 
	public Personne getPersonneById(int idConnect);
	

}// end interface
