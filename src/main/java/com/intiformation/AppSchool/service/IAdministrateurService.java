package com.intiformation.AppSchool.service;


import com.intiformation.AppSchool.modele.Administrateur;
import com.intiformation.AppSchool.modele.Personne;

/**
 * interface de la couche service pour l'administrateur
 * interface qui etend IUniverselService
 *
 * @author anais
 *
 */
public interface IAdministrateurService extends IUniverselService<Administrateur> {
	
	/*__________ Méthodés spécifiques à l'adminitrateur __________*/ 
	public Personne findPersonneById(int idConnect);

}// end interface
