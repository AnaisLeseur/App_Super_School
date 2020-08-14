package com.intiformation.AppSchool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LanguageController {

	private String Language;
	
	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}
	
	@RequestMapping(value = "/LangueFR", method = RequestMethod.GET)
	public void setLanguageFR() {
		Language = "FR";
	}
	
	@RequestMapping(value = "/LangueEN", method = RequestMethod.GET)
	public void setLanguageEN() {
		Language = "EN";
	}
	
}//end class


