package com.intiformation.AppSchool.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aide implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aideId;
	
	@Column(length=50)
	private String titre;
	
	@Column(length=1000)
	private String contenu;

	public Aide() {
	}

	public Aide(String titre, String contenu) {
		this.titre = titre;
		this.contenu = contenu;
	}

	public Aide(int aideId, String titre, String contenu) {
		this.aideId = aideId;
		this.titre = titre;
		this.contenu = contenu;
	}

	public int getAideId() {
		return aideId;
	}

	public void setAideId(int aideId) {
		this.aideId = aideId;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
