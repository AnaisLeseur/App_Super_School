package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IMatiereDAO;
import com.intiformation.AppSchool.modele.Matiere;

@Service
public class MatiereServiceImpl implements IMatiereService {

	@Autowired // ijection du bean de la doa dans cette prop
	private IMatiereDAO matiereDAO;
	/**
	 * setter matieredao pour injection par modificateur de spring
	 * @param matiereDAO
	 */
	public void setMatiereDAO(IMatiereDAO matiereDAO) {
		this.matiereDAO = matiereDAO;
	}
	
	
	
	@Override
	public void ajouterMatiere(Matiere pMatiere) {

		matiereDAO.add(pMatiere);

		
	}

	

	@Override
	public void modfierMatiere(Matiere pMatiere) {
		matiereDAO.update(pMatiere);
	}

	@Override
	public void supprimerMatiere(int pIdMatiere) {
		matiereDAO.delete(pIdMatiere);
	}

	@Override
	public Matiere findByIdMatiere(int pIdMatiere) {
		return matiereDAO.getById(pIdMatiere);
	}

	@Override
	public List<Matiere> findAllMatiere() {
		return matiereDAO.getAll();
	}

}//end class
