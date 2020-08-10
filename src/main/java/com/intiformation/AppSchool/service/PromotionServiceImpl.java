package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IPromotionDAO;
import com.intiformation.AppSchool.modele.Promotion;

@Service
public class PromotionServiceImpl implements IPromotionService {

	@Autowired
	private IPromotionDAO promotionDAO;
	
	
	//setter de promotion
	public void setPromotionDAO(IPromotionDAO promotionDAO) {
		this.promotionDAO = promotionDAO;
	}

	@Override
	public void ajouter(Promotion pPromotion) {
		promotionDAO.add(pPromotion);
	}//end ajout

	@Override
	public void modifier(Promotion pPromotion) {
		promotionDAO.update(pPromotion);
	}//end modif

	@Override
	public void supprimer(Integer idPromotion) {
		promotionDAO.delete(idPromotion);
		
	}//end promotion

	@Override
	public List<Promotion> findAll() {
		return promotionDAO.getAll() ;
	}//end getAll

	@Override
	public Promotion findById(Integer idPromotion) {
		return promotionDAO.getById(idPromotion);
	}//end getById

	@Override
	public List<Promotion> findListNotLinkedToEtudiant(int pIdEtudiant) {
		return promotionDAO.getListNotLinkedToEtudiant(pIdEtudiant);
	}

}//end service