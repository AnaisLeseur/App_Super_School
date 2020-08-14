package com.intiformation.AppSchool.modele;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	
		rootContext.register(WebConfig.class);
		
		container.addListener(new ContextLoaderListener(rootContext));
	
		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", (Servlet) new DispatcherServlet(dispatcherServlet));
	
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}//end onStartup()

}//end class
