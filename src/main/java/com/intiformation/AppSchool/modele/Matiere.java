package com.intiformation.AppSchool.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Matiere {

	
	//-------------------------prop-------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMatiere;
	
	private String libelle;
	
	private int FkEnseignant;
	
	//-------------------------ctor-------------------------------------

	public Matiere() {
	}
	

	
	public Matiere(int idMatiere, String libelle, int fkEnseignant) {
		super();
		this.idMatiere = idMatiere;
		this.libelle = libelle;
		this.FkEnseignant = fkEnseignant;
	}
	

	public Matiere(String libelle, int fkEnseignant) {
		super();
		this.libelle = libelle;
		this.FkEnseignant = fkEnseignant;
	}



	//-------------------------setter-------------------------------------

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public int getFkEnseignant() {
		return FkEnseignant;
	}



	public void setFkEnseignant(int fkEnseignant) {
		FkEnseignant = fkEnseignant;
	}
	
	
}//end class
