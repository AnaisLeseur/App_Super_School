package com.intiformation.AppSchool.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * classe modele pour un Enseignant. 
 * classe qui etend Personne
 * 
 * @author vincent
 *
 */
@Entity
@DiscriminatorValue(value = "ROLE_Enseignant")
@PrimaryKeyJoinColumn(name="identifiant",
referencedColumnName="identifiant")
public class Enseignant extends Personne {
	
	// ---- Propriétés ----
	@OneToMany(mappedBy="enseignantEJ",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EnseigneJointure> listeEnseigneJointureEns= new ArrayList<>();
	
	// ---- Ctors ----
	// Ctors vide
	public Enseignant() {
	}

	// Ctor avec les props de la classe 'Personne'
	
	public Enseignant(int identifiant, String motDePasse, String nom, String prenom, String email, Adresse adresse) {
		super(identifiant, motDePasse, nom, prenom, email, adresse);
	}

	public Enseignant(int identifiant, String motDePasse, String nom, String prenom, String email) {
		super(identifiant, motDePasse, nom, prenom, email);
	}

	public Enseignant(String motDePasse, String nom, String prenom, String email) {
		super(motDePasse, nom, prenom, email);
	}
	
	// ---- Meths ----
	// ---- Getters / Setters ----
	
	public List<EnseigneJointure> getListeEnseigneJointureEns() {
		return listeEnseigneJointureEns;
	}

	public void setListeEnseigneJointureEns(List<EnseigneJointure> listeEnseigneJointureEns) {
		this.listeEnseigneJointureEns = listeEnseigneJointureEns;
	}
	

}// end Enseignant
