package com.intiformation.AppSchool.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	
	@ManyToOne
	@JoinColumn(referencedColumnName="idPromotion")
	private Promotion promotion;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="idMatiere" , name="idMatiere")
	private Matiere matiere;
	
	//Ajout pour EtudiantCours Thomas
	@OneToMany(mappedBy="coursEC", cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EtudiantCours> listeEtudiantsCours;
	
	//-------------------------------ctor-------------------------------------------------------
	
	public Cours() {
	}

	public Cours(int idCours, String libelle, String description, int duree, Date date) {
		this.idCours = idCours;
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;

	}

	public Cours(String libelle, String description, int duree, Date date  ) {
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
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

	public Promotion getPromotion() {
		return promotion;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public List<EtudiantCours> getListeEtudiantsCours() {
		return listeEtudiantsCours;
	}

	public void setListeEtudiantsCours(List<EtudiantCours> listeEtudiantsCours) {
		this.listeEtudiantsCours = listeEtudiantsCours;
	}

}//end cours
