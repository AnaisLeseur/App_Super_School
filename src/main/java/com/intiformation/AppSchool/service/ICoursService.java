package com.intiformation.AppSchool.service;

import java.util.List;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Promotion;


/**
 * interface de la couche service pour la gestion des cours
 * @author 
 *
 */
public interface ICoursService {

	public void ajouterCours(Cours pCours);
	
	public void modfierCours(Cours pCours);

	public void supprimerCours(int pIdCours);

	public Cours findByIdCours(int pIdCours);

	public List<Cours> findAllCours();
	
	/*__________ Méthodés spécifiques pour le gestion des Cours __________*/ 
	public List<Cours> recupCoursParMatiere (int pIdMatiere);
	
public Cours ajouterReturnCours(Cours pCours);
	
	public List<Promotion> findListPromoByIdCours(int pIdCours);
	
	
}//end interface
