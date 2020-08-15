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

import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.Personne;
import com.intiformation.AppSchool.service.IAdministrateurService;
import com.intiformation.AppSchool.service.IEtudiantService;

@Controller
public class AuthentificationController {
	
	@Autowired
	private IAdministrateurService adminService;
	
	@Autowired
	private IEtudiantService etudiantService;
	
	//Setter pour injection
	public void setAdminService(IAdministrateurService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value = "/connect/getUser", method = RequestMethod.GET)
	public String getConnectUser(HttpServletRequest request, Authentication authentication, ModelMap model) {
		System.out.println("j'ai reussi");

		int idConnect = Integer.parseInt(authentication.getName());
		System.out.println(idConnect);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String authorities = userDetails.getAuthorities().toString();
		
		Personne personne = adminService.findPersonneById(idConnect);
		HttpSession session = request.getSession(true);
		session.setAttribute("ConnectUser", personne);
		
		System.out.println(authorities);
		
		switch (authorities) {
		case "[ROLE_Admin]":
			
			session.setAttribute("Role", "Admin");
			return "XXXXX";
			
		case "[ROLE_Etudiant]":
			
			Etudiant etudiant = etudiantService.findById(idConnect);
			model.addAttribute("etudiantSeeCommand", etudiant);
			session.setAttribute("Role", "Etudiant");
			
			return "Etudiant/seeEtudiant";
			
		case "[ROLE_Enseignant]":
			session.setAttribute("Role", "Enseignant");
			return "XXX";

		default:
			break;
		}
		
		return "liste-cours";

	}// end recupListe

}
