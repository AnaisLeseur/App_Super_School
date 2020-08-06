package com.intiformation.AppSchool.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intiformation.AppSchool.dao.IPromotionDAO;
import com.intiformation.AppSchool.modele.Promotion;

@Service
public class PromotionServiceImpl implements IPromotionService {

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
		// TODO Auto-generated method stub
		return promotionDAO.getAll();
	}

	@Override
	public Promotion findById(Integer idPromotion) {
		// TODO Auto-generated method stub
		return promotionDAO.getById(idPromotion);
	}

}
