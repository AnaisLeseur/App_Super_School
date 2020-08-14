package com.intiformation.AppSchool.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Matiere {

	
	//-------------------------prop-------------------------------------
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMatiere;
	
	private String libelle;
	
	@OneToMany(mappedBy="matiere")
	private List<Cours> listeCours;
	
	@OneToMany(mappedBy="matiereEJ",cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EnseigneJointure> listeEnseigneJointureMat= new ArrayList<>();
	
	//-------------------------ctor-------------------------------------

	public Matiere() {
	}
	
	public Matiere(int idMatiere, String libelle) {
		super();
		this.idMatiere = idMatiere;
		this.libelle = libelle;
	}
	
	public Matiere(String libelle) {
		super();
		this.libelle = libelle;
	}


	//-------------------------setter-------------------------------------

	public int getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	public List<EnseigneJointure> getListeEnseigneJointureMat() {
		return listeEnseigneJointureMat;
	}

	public void setListeEnseigneJointureMat(List<EnseigneJointure> listeEnseigneJointureMat) {
		this.listeEnseigneJointureMat = listeEnseigneJointureMat;
	}
	
}//end class
