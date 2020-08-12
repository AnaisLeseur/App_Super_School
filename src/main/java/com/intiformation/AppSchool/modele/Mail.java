package com.intiformation.AppSchool.modele;

import java.io.Serializable;

public class Mail implements Serializable {

	// props
	private String Subject;
	private String content;
	
	// ctors
	/**
	 * ctor chargé
	 * @param object
	 * @param content
	 */
	public Mail(String subject, String content) {
		super();
		this.Subject = subject;
		this.content = content;
	}
	
	
	/**
	 * ctor vide
	 */
	public Mail() {
		super();
	}


	// gt&st
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		this.Subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}//end class
