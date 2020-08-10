package com.intiformation.AppSchool.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cours {

	//--------------------------------prop--------------------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCours;	
	
	private String libelle;
	
	private String description;
	
	private int duree; // duree du cours en minute
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	private Long fkEtudiant;
	
	private Long fkMatiere;
	
	//Ajout pour EtudiantCours Thomas
	@OneToMany(mappedBy="coursEC", cascade=CascadeType.ALL)
	private List<EtudiantCours> listeEtudiantsCours;
	
	//-------------------------------ctor-------------------------------------------------------
	
	public Cours() {
	}

	public Cours(int idCours, String libelle, String description, int duree, Date date, Long fkEtduiant,
			Long fkMatiere) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
		this.fkEtudiant = fkEtduiant;
		this.fkMatiere = fkMatiere;
	}

	public Cours(String libelle, String description, int duree, Date date, Long fkEtudiant, Long fkMatiere) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
		this.fkEtudiant = fkEtudiant;
		this.fkMatiere = fkMatiere;
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

	public Long getFkEtudiant() {
		return fkEtudiant;
	}

	public void setFkEtudiant(Long fkEtudiant) {
		this.fkEtudiant = fkEtudiant;
	}

	public Long getFkMatiere() {
		return fkMatiere;
	}

	public void setFkMatiere(Long fkMatiere) {
		this.fkMatiere = fkMatiere;
	}

	public List<EtudiantCours> getListeEtudiantsCours() {
		return listeEtudiantsCours;
	}

	public void setListeEtudiantsCours(List<EtudiantCours> listeEtudiantsCours) {
		this.listeEtudiantsCours = listeEtudiantsCours;
	}

}//end cours
