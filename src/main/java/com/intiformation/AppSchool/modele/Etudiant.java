package com.intiformation.AppSchool.modele;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Etudiant extends Personne{
	
	//Propriétés
	@Column(length=50)
	private String photo;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@ManyToMany
	private List<Promotion> listePromotions;
	
	
	//Constructeurs
	public Etudiant() {
	}
	
	public Etudiant(String photo, Date dateNaissance) {
		this.photo = photo;
		this.dateNaissance = dateNaissance;
	}

	public Etudiant(String photo, Date dateNaissance, List<Promotion> listePromotions) {
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

}//end class
