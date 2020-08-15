package com.intiformation.AppSchool.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.AppSchool.modele.Enseignant;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Personne;
import com.intiformation.AppSchool.service.IAdministrateurService;
import com.intiformation.AppSchool.service.IEnseignantService;
import com.intiformation.AppSchool.service.IEtudiantService;

@Controller
public class AuthentificationController {
	
	@Autowired
	private IAdministrateurService adminService;
	
	@Autowired
	private IEtudiantService etudiantService;
	
	@Autowired
	private IEnseignantService enseignantService;
	
	//Setter pour injection
	public void setAdminService(IAdministrateurService adminService) {
		this.adminService = adminService;
	}

	public void setEtudiantService(IEtudiantService etudiantService) {
		this.etudiantService = etudiantService;
	}

	public void setEnseignantService(IEnseignantService enseignantService) {
		this.enseignantService = enseignantService;
	}



	@RequestMapping(value = "/connect/getUser", method = RequestMethod.GET)
	public String getConnectUser(HttpServletRequest request, Authentication authentication, ModelMap model) {

		int idConnect = Integer.parseInt(authentication.getName());
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String authorities = userDetails.getAuthorities().toString();
		
		Personne personne = adminService.findPersonneById(idConnect);
		HttpSession session = request.getSession(true);
		session.setAttribute("ConnectUser", personne);
		
		switch (authorities) {
		case "[ROLE_Admin]":
			
			session.setAttribute("Role", "Admin");
			return "redirect:/administrateurs/liste";
			
		case "[ROLE_Etudiant]":
			
			Etudiant etudiant = etudiantService.findById(idConnect);
			model.addAttribute("etudiantSeeCommand", etudiant);
			session.setAttribute("Role", "Etudiant");
			
			return "Etudiant/seeEtudiant";
			
		case "[ROLE_Enseignant]":
			Enseignant enseignant = enseignantService.findById(idConnect);
			model.addAttribute("enseignantVoirCommand", enseignant);
			session.setAttribute("Role", "Enseignant");
			return "Personnel/voir-enseignant";

		default:
			break;
		}
		
		return "liste-cours";

	}// end recupListe

}
