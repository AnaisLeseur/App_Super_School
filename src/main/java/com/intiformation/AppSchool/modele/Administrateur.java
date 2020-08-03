package com.intiformation.AppSchool.modele;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;


/**
 * classe modele pour un administrateur. 
 * classe qui etend Personne
 * 
 * @author vincent
 *
 */
@Entity
@DiscriminatorValue(value = "administrateurs")
@PrimaryKeyJoinColumn(name="personne_id",
					  referencedColumnName="identifiant")
public class Administrateur extends Personne {
	
	// ---- Propriétés ----
	
	
	// ---- Ctors ----
	// Ctors vide
	public Administrateur() {
	}

	// Ctor avec les props de la classe 'Personne'
	
	public Administrateur(int identifiant, String motDePasse, String nom, String prenom, String email,
			Adresse adresse) {
		super(identifiant, motDePasse, nom, prenom, email, adresse);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	// ---- Meths ----
	// ---- Getters / Setters ----
	

}// end Administrateur
