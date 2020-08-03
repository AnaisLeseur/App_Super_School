package com.intiformation.AppSchool.modele;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Promotion implements Serializable{
	
	//Propriétés
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPromotion;
	
	@Column(length=30)
	private String libelle;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Promotion_Etudiant",
				joinColumns=@JoinColumn(name="promotion_id"),
				inverseJoinColumns=@JoinColumn(name="etudiant_id"))
	private List<Etudiant> listeEtudiants;

	//Constructeurs
	public Promotion() {
	}

	public Promotion(String libelle, List<Etudiant> listeEtudiants) {
		this.libelle = libelle;
		this.listeEtudiants = listeEtudiants;
	}

	public Promotion(Long idPromotion, String libelle, List<Etudiant> listeEtudiants) {
		this.idPromotion = idPromotion;
		this.libelle = libelle;
		this.listeEtudiants = listeEtudiants;
	}

	//Getter Setter
	public Long getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(Long idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}
	
}
