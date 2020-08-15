package com.intiformation.AppSchool.service;


import java.util.List;

import com.intiformation.AppSchool.modele.Enseignant;
import com.intiformation.AppSchool.modele.Etudiant;


/**
 * interface de la couche service pour l'enseignant
 *
 * @author anais
 *
 */
public interface IEnseignantService extends IUniverselService<Enseignant> {
	
	/*__________ Méthodés spécifiques à l'enseignant  __________*/ 
	public List<Etudiant> findListEtudiantByIdEnseignant(int idEnseignant);

}// end interface
