package com.intiformation.AppSchool.modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cours {

	//--------------------------------prop--------------------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCours;	
	
	private String libelle;
	
	private String description;
	
	private int duree; // duree du cours en minute
	
	private Date date;
	
	private Long FkEtduiant;
	
	private Long FkMatiere;
	
	//-------------------------------ctor-------------------------------------------------------
	
	public Cours() {
	}

	public Cours(Long idCours, String libelle, String description, int duree, Date date, Long fkEtduiant,
			Long fkMatiere) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
		FkEtduiant = fkEtduiant;
		FkMatiere = fkMatiere;
	}

	public Cours(String libelle, String description, int duree, Date date, Long fkEtduiant, Long fkMatiere) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
		this.FkEtduiant = fkEtduiant;
		this.FkMatiere = fkMatiere;
	}

	
	
	
	
	
	
	//-------------------------------getter et setter-----------------------------------------
	
	
	
	
	
}//end cours
