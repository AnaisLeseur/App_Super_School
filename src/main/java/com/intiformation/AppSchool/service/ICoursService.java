package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Cours;



public interface ICoursService {

public void ajouterCours(Cours pCours);
	
	public void modfierCours(Cours pCours);

	public void supprimerCours(int pIdCours);

	public Cours findByIdCours(int pIdCours);

	public List<Cours> findAllCours();
	
}//end interface
