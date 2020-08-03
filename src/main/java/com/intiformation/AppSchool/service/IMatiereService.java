package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Matiere;

public interface IMatiereService {

public void ajouterMatiere(Matiere pMatiere);
	
	public void modfierMatiere(Matiere pMatiere);

	public void supprimerMatiere(int pIdMatiere);

	public Matiere findByIdMatiere(int pIdMatiere);

	public List<Matiere> findAllMatiere();
	
	
}//end interface
