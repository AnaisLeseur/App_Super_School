package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Enseignant;


/**
 * interface de la couche service pour l'enseignant
 *
 * @author anais
 *
 */
public interface IEnseignantService {
	
	public void ajoutEnseignant(Enseignant pEnseignant);
	
	public void modifierEnseignant(Enseignant pEnseignant);
	
	public void supprimerEnseignant(int pIdEnseignant);
	
	public Enseignant findEnseignantById(int pIdEnseignant);
	
	public List<Enseignant> findAllEnseignant();
	

}// end interface
