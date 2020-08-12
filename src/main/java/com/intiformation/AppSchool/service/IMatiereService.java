package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Matiere;

/**
 * interface de la couche service pour la gestion des matières
 * @author 
 *
 */
public interface IMatiereService {

	public void ajouterMatiere(Matiere pMatiere);
	
	public void modfierMatiere(Matiere pMatiere);

	public void supprimerMatiere(int pIdMatiere);

	public Matiere findByIdMatiere(int pIdMatiere);

	public List<Matiere> findAllMatiere();
	
	
	/*__________ Méthodés spécifiques pour le gestion des matières __________*/ 
	
	
	
	
}//end interface
