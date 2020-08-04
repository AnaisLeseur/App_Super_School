package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IAdresseDAO;
import com.intiformation.AppSchool.modele.Adresse;

@Service
public class AdresseServiceImp implements IAdresseService{
	
	@Autowired 
	private IAdresseDAO adresseDAO;
	/**
	 * setter pour injection par modificateur de spring
	 */
	public void setAdresseDAO(IAdresseDAO adresseDAO) {
		this.adresseDAO = adresseDAO;
	}
	
	
	@Override
	public void ajouter(Adresse pAdresse) {
		adresseDAO.add(pAdresse);
	}

	@Override
	public void modifier(Adresse pAdresse) {
		adresseDAO.update(pAdresse);
	}

	@Override
	public void supprimer(Integer idAdresse) {
		adresseDAO.delete(idAdresse);
	}

	@Override
	public List<Adresse> findAll() {
		return adresseDAO.getAll();
	}

	@Override
	public Adresse findById(Integer idAdresse) {
		return adresseDAO.getById(idAdresse);
	}

}//end class
