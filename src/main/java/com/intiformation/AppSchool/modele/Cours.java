package com.intiformation.AppSchool.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cours {

	//--------------------------------prop--------------------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCours;	
	
	private String libelle;
	
	private String description;
	
	private int duree; // duree du cours en minute
	
	private Date date;
	
	private int FkEtduiant;
	
	private int FkMatiere;
	
	//Ajout pour EtudiantCours Thomas
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="EtudiantCours",
				joinColumns=@JoinColumn(name="promotion_id"),
				inverseJoinColumns=@JoinColumn(name="etudiant_id"))
	private List<Etudiant> listeEtudiants;*/
	
	//-------------------------------ctor-------------------------------------------------------
	
	public Cours() {
	}

	public Cours(int idCours, String libelle, String description, int duree, Date date, int fkEtduiant,
			int fkMatiere) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
		FkEtduiant = fkEtduiant;
		FkMatiere = fkMatiere;
	}

	public Cours(String libelle, String description, int duree, Date date, int fkEtduiant, int fkMatiere) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
		this.FkEtduiant = fkEtduiant;
		this.FkMatiere = fkMatiere;
	}
	
	
	
	//-------------------------------getter et setter-----------------------------------------

	

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdCours() {
		return idCours;
	}

	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}

	public int getFkEtduiant() {
		return FkEtduiant;
	}

	public void setFkEtduiant(int fkEtduiant) {
		FkEtduiant = fkEtduiant;
	}

	public int getFkMatiere() {
		return FkMatiere;
	}

	public void setFkMatiere(int fkMatiere) {
		FkMatiere = fkMatiere;
	}

	

	/*public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}*/
	
}//end cours
