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
	private Etudiant etudiantEC;
	
	@ManyToOne
	@JoinColumn(referencedColumnName="idCours")
	private Cours coursEC;
	
	private boolean absence;
	
	@Column(length=200)
	private String motif;
	
	//Constructeurs
	
	public EtudiantCours() {
	}

	public EtudiantCours(Etudiant etudiant, Cours cours, boolean absence, String motif) {
		this.etudiantEC = etudiant;
		this.coursEC = cours;
		this.absence = absence;
		this.motif = motif;
	}

	public EtudiantCours(int idEtudiantCours, Etudiant etudiant, Cours cours, boolean absence, String motif) {
		this.idEtudiantCours = idEtudiantCours;
		this.etudiantEC = etudiant;
		this.coursEC = cours;
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
		return etudiantEC;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiantEC = etudiant;
	}

	public Cours getCours() {
		return coursEC;
	}

	public void setCours(Cours cours) {
		this.coursEC = cours;
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
