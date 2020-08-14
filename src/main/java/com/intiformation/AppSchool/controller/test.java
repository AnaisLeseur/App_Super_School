package com.intiformation.AppSchool.controller;


import java.security.Principal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class test {
	
	@RequestMapping(value = "/accueil/test", method = RequestMethod.GET)
	public String testqsdfsfsf(Principal principal) {
		System.out.println("j'ai reussi");
		System.out.println("j'ai reussi");
		System.out.println("j'ai reussi");
		System.out.println(principal.getName());
		UserDetails userDetails = (UserDetails) principal;
		System.out.println(userDetails.getAuthorities());
		return "accueil";

	}// end recupListe

}
