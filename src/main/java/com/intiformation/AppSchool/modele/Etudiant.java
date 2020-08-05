package com.intiformation.AppSchool.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.servlet.http.Part;

@Entity
@DiscriminatorValue(value = "Etudiant")
@PrimaryKeyJoinColumn(name="personne_id",
referencedColumnName="identifiant")
public class Etudiant extends Personne{
	
	
	//Propriétés
	@Column(length=50)
	private String photo;
	
	@Transient
	private Part uploadedPhoto;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@ManyToMany(mappedBy="listeEtudiants")
	private List<Promotion> listePromotions;
	/*
	@OneToMany(mappedBy="coursEC")
	private List<EtudiantCours> listeEtudiantCours;
	*/
	
	//Constructeurs
	public Etudiant() {
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

	public Part getUploadedPhoto() {
		return uploadedPhoto;
	}

	public void setUploadedPhoto(Part uploadedPhoto) {
		this.uploadedPhoto = uploadedPhoto;
	}
/*
	public List<EtudiantCours> getListeEtudiantCours() {
		return listeEtudiantCours;
	}

	public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
		this.listeEtudiantCours = listeEtudiantCours;
	}
*/
}//end class
