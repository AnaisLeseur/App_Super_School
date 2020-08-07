package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IAideDAO;
import com.intiformation.AppSchool.modele.Aide;

@Service
public class AideServiceImpl implements IAideService {

	@Autowired // ijection du bean de la doa dans cette prop
	private IAideDAO aideDAO;
	/**
	 * setter matieredao pour injection par modificateur de spring
	 * @param matiereDAO
	 */
	public void setAideDAO(IAideDAO aideDAO) {
		this.aideDAO = aideDAO;
	}
	
	
	@Override
	public void ajouter(Aide pAide) {

		aideDAO.add(pAide);
		
	}//end ajouter

	

	@Override
	public void modifier(Aide pAide) {
		// TODO Auto-generated method stub
		aideDAO.update(pAide);
	}//end modifier

	@Override
	public void supprimer(Integer IdAide) {
		// TODO Auto-generated method stub
		aideDAO.delete(IdAide);
	}// end supprimer 

	@Override
	public List<Aide> findAll() {
		// TODO Auto-generated method stub
		return aideDAO.getAll();
	}

	@Override
	public Aide findById(Integer IdAide) {
		// TODO Auto-generated method stub
		return aideDAO.getById(IdAide);
	}

}//end service
