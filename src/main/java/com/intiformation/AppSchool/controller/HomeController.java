package com.intiformation.AppSchool.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	Logger log = Logger.getLogger(HomeController.class.getName());
	
	@GetMapping(value = "/index2")
    public String welcomePage() {
        log.info("INTO index");
        return "index2";
    }
}//end class
