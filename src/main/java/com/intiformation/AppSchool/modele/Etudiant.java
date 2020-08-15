package com.intiformation.AppSchool.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.web.multipart.MultipartFile;

@Entity
@DiscriminatorValue(value = "ROLE_Etudiant")
@PrimaryKeyJoinColumn(name="identifiant",
referencedColumnName="identifiant")
public class Etudiant extends Personne{
	
	
	//Propriétés
	@Column(length=50)
	private String photo;
	
	@Transient
	private MultipartFile uploadedPhoto;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@ManyToMany(mappedBy="listeEtudiants", fetch=FetchType.EAGER)
	private List<Promotion> listePromotions = new ArrayList<>();
	
	@OneToMany(mappedBy="etudiantEC",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EtudiantCours> listeEtudiantCours = new ArrayList<>();
	
	
	//Constructeurs
	public Etudiant() {
	}
	
	public Etudiant(int identifiant, String motDePasse, String nom, String prenom, String email, Adresse adresse) {
		super(identifiant, motDePasse, nom, prenom, email, adresse);
	}

	public Etudiant(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
	}

	public Etudiant(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
	}

	public Etudiant(String photo, Date dateNaissance) {
		this.photo = photo;
		this.dateNaissance = dateNaissance;
	}

	public Etudiant(String motDePasse, String nom, String prenom, String email,String photo, Date dateNaissance) {
		super(motDePasse, nom, prenom, email);
		this.photo = photo;
		this.dateNaissance = dateNaissance;
	}

	public Etudiant(String photo, Date dateNaissance, List<Promotion> listePromotions) {
		super();
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.listePromotions = listePromotions;
	}

	//Getter Setter
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Promotion> getListePromotions() {
		return listePromotions;
	}

	public void setListePromotions(List<Promotion> listePromotions) {
		this.listePromotions = listePromotions;
	}

	public MultipartFile getUploadedPhoto() {
		return uploadedPhoto;
	}

	public void setUploadedPhoto(MultipartFile uploadedPhoto) {
		this.uploadedPhoto = uploadedPhoto;
	}

	public List<EtudiantCours> getListeEtudiantCours() {
		return listeEtudiantCours;
	}

	public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
		this.listeEtudiantCours = listeEtudiantCours;
	}

}//end class
