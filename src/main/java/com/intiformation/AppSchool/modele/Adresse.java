package com.intiformation.AppSchool.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable{
	
	//Propriétés
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idAdresse;
	
	@Column(length=10)
	private String codePostal;
	
	@Column(length=30)
	private String ville;

	//Constructeur
	
	public Adresse() {
	}

	public Adresse(String codePostal, String ville) {
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse(Long idAdresse, String codePostal, String ville) {
		this.idAdresse = idAdresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	//Getter Setter

	public Long getIdAdresse() {
		return idAdresse;
	}

	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}//end class
