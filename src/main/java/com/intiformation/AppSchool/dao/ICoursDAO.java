package com.intiformation.AppSchool.dao;

import java.util.List;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Promotion;

/**
 * Interface DAO spécifique à un Cours
 * Hérite de IUniverselDAO
 * 
 * @author 
 *
 */
public interface ICoursDAO extends IUniverselDAO<Cours> {
	
	/*__________ Méthodés spécifiques à la gestion des cours __________*/ 
	
	/**
	 * methode pour récupérer la liste des cours appartenant/liés à une matière
	 * @param pIdMatiere : id de la matière 
	 * @return : la liste des cours 
	 */
	public List<Cours> FindCoursAssociesAMatiere (int pIdMatiere);
	
public Cours addReturnCours(Cours pCours);
	
	public List<Promotion> getListPromoByIdCours(int pIdCours);
	

}//end interface
