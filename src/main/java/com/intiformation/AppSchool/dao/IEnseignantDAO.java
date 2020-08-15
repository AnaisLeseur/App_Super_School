package com.intiformation.AppSchool.dao;

import java.util.List;

import com.intiformation.AppSchool.modele.Enseignant;
import com.intiformation.AppSchool.modele.Etudiant;

/**
 * Interface DAO spécifique à un enseignant
 * Hérite de IUniverselDAO
 * 
 * @author anais
 *
 */
public interface IEnseignantDAO extends IUniverselDAO<Enseignant> {
	
	/*__________ Méthodés spécifiques à un enseignant __________*/ 
	public List<Etudiant> getListEtudiantByIdEnseignant(int idEnseignant);
	
}// end interface
