package com.intiformation.AppSchool.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

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
	
	@Column(length=1000)
	private String exercice;
	
	@Transient
	private List<MultipartFile> listeUploadedExercice;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="idPromotion")
	private Promotion promotion;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="idMatiere" , name="idMatiere")
	private Matiere matiere;
	
	//Ajout pour EtudiantCours Thomas
	@OneToMany(mappedBy="coursEC", cascade={CascadeType.PERSIST,CascadeType.MERGE})
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
	
	//Ajout pour exercice
	
	public String getExercice() {
		return exercice;
	}

	public void setExercice(String exercice) {
		this.exercice = exercice;
	}


	public List<MultipartFile> getListeUploadedExercice() {
		return listeUploadedExercice;
	}

	public void setListeUploadedExercice(List<MultipartFile> listeUploadedExercice) {
		this.listeUploadedExercice = listeUploadedExercice;
	}

	public Cours(String libelle, String description, int duree, Date date, String exercice) {
		this.libelle = libelle;
		this.description = description;
		this.duree = duree;
		this.date = date;
		this.exercice = exercice;
	}

}//end cours
