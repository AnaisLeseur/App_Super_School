package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.ICoursDAO;
import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Promotion;

@Service
public class CoursServiceImpl implements ICoursService {

	@Autowired // ijection du bean de la doa dans cette prop
	private ICoursDAO coursDAO;
	/**
	 * setter coursdao pour injection par modificateur de spring
	 * @param coursDAO
	 */
	public void setCoursDAO(ICoursDAO coursDAO) {
		this.coursDAO = coursDAO;
	}
	
	@Override
	public void ajouterCours(Cours pCours) {
		// TODO Auto-generated method stub
		coursDAO.add(pCours);
	}

	

	@Override
	public void modfierCours(Cours pCours) {
     
		coursDAO.update(pCours);
		
	}

	@Override
	public void supprimerCours(int pIdCours) {
		// TODO Auto-generated method stub
		coursDAO.delete(pIdCours);
	}

	@Override
	public Cours findByIdCours(int pIdCours) {

		
		return coursDAO.getById(pIdCours);
	}

	@Override
	public List<Cours> findAllCours() {
		// TODO Auto-generated method stub
		return coursDAO.getAll();
	}

	/**
	 * methode pour récupérer la liste des cours associés à une matiere 
	 */
	@Override
	public List<Cours> recupCoursParMatiere(int pIdMatiere) {
		return coursDAO.FindCoursAssociesAMatiere(pIdMatiere);
	}// end recupCoursParMatiere

	@Override
	public Cours ajouterReturnCours(Cours pCours) {
		// TODO Auto-generated method stub
		return coursDAO.addReturnCours(pCours);
	}

	@Override
	public List<Promotion> findListPromoByIdCours(int pIdCours) {
		// TODO Auto-generated method stub
		return coursDAO.getListPromoByIdCours(pIdCours);
	}

}
