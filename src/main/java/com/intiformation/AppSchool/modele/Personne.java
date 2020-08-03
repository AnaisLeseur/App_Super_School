package com.intiformation.AppSchool.modele;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="ROLE",
					 discriminatorType = DiscriminatorType.STRING)
public abstract class Personne implements Serializable{
	
	//Propriétés
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long identifiant;
	
	@Column(length=30)
	private String motDePasse;
	
	@Column(length=30)
	private String nom;
	
	@Column(length=30)
	private String prenom;
	
	@Column(length=50)
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(referencedColumnName="idAdresse")
	private Adresse adresse;

	
	//Constructeurs 
	public Personne() {
	}

	public Personne(String motDePasse, String nom, String prenom, String email) {
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Personne(Long identifiant, String motDePasse, String nom, String prenom, String email) {
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	public Personne(Long identifiant, String motDePasse, String nom, String prenom, String email, Adresse adresse) {
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	//Getter Setter

	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}//end class
