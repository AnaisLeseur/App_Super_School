package com.intiformation.AppSchool.modele;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * classe modele pour un Enseignant. 
 * classe qui etend Personne
 * 
 * @author vincent
 *
 */
@Entity
@DiscriminatorValue(value = "enseignants")
@PrimaryKeyJoinColumn(name="personne_id",
referencedColumnName="identifiant")
public class Enseignant extends Personne {
	
	// ---- Propriétés ----
	
	
	// ---- Ctors ----
	// Ctors vide
	public Enseignant() {
	}

	
	// Ctor avec les props de la classe 'Personne'
	
	public Enseignant(int identifiant, String motDePasse, String nom, String prenom, String email, Adresse adresse) {
		super(identifiant, motDePasse, nom, prenom, email, adresse);
		// TODO Auto-generated constructor stub
	}

	public Enseignant(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	public Enseignant(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	
	
	
	// ---- Meths ----
	// ---- Getters / Setters ----
	

}// end Enseignant
