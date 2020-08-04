package com.intiformation.AppSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.intiformation.AppSchool.service.IAdministrateurService;
import com.intiformation.AppSchool.validator.AdministrateurValidator;

/**
 * implementation d'un controleur spring mvc pour la gestion des administrateurs.
 * Gestion opération CRUD de l'administrateur
 * @author anais
 *
 */
@Controller // déclaration de la classe comme bean spring de type controleur spring mvc 
public class AdministrateurController {
	
	// déclaration service
	@Autowired // injection du bean de la couche service dans cette prop 'employeService'
	private IAdministrateurService adminService;

	
	// déclaration du validateur
	@Autowired
	private AdministrateurValidator adminValidator; 
	
	
	/**
	 * setter de la couche service pour injection spring 
	 * 
	 * @param adminService
	 */
	@Autowired
	public AdministrateurController(IAdministrateurService adminService) {
		this.adminService = adminService;
	}// end ctor


	/**
	 * setter pour le validateur pour injection spring 
	 * 
	 * @param adminValidator
	 */
	public void setAdminValidator(AdministrateurValidator adminValidator) {
		this.adminValidator = adminValidator;
	}// end ctor
	
	

	//----------------- METHODES --------------------
	// Meths gestionnaires du controleur 
	
	
	

}// end AdministrateurController
