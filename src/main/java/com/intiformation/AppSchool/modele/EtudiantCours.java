package com.intiformation.AppSchool.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*
@Entity
public class EtudiantCours implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEtudiantCours;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="identifiant")
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="idCours")
	private Cours cours;
	
	private boolean absence;
	
	@Column(length=200)
	private String motif;
	
	//Constructeurs
	
	public EtudiantCours() {
	}

	public EtudiantCours(Etudiant etudiant, Cours cours, boolean absence, String motif) {
		this.etudiant = etudiant;
		this.cours = cours;
		this.absence = absence;
		this.motif = motif;
	}

	public EtudiantCours(int idEtudiantCours, Etudiant etudiant, Cours cours, boolean absence, String motif) {
		this.idEtudiantCours = idEtudiantCours;
		this.etudiant = etudiant;
		this.cours = cours;
		this.absence = absence;
		this.motif = motif;
	}

	//Getter Setter

	public int getIdEtudiantCours() {
		return idEtudiantCours;
	}

	public void setIdEtudiantCours(int idEtudiantCours) {
		this.idEtudiantCours = idEtudiantCours;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public boolean isAbsence() {
		return absence;
	}

	public void setAbsence(boolean absence) {
		this.absence = absence;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

}
*/
