package com.intiformation.AppSchool.modele;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	private Boolean absence;
	
	@Column(length=200)
	private String motif;
	
	//Constructeurs
	
	public EtudiantCours() {
	}

	public EtudiantCours(Etudiant etudiant, Cours cours, Boolean absence, String motif) {
		this.etudiantEC = etudiant;
		this.coursEC = cours;
		this.absence = absence;
		this.motif = motif;
	}

	public EtudiantCours(int idEtudiantCours, Etudiant etudiant, Cours cours, Boolean absence, String motif) {
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

	public Boolean isAbsence() {
		return absence;
	}

	public void setAbsence(Boolean absence) {
		this.absence = absence;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Etudiant getEtudiantEC() {
		return etudiantEC;
	}

	public void setEtudiantEC(Etudiant etudiantEC) {
		this.etudiantEC = etudiantEC;
	}

	public Cours getCoursEC() {
		return coursEC;
	}

	public void setCoursEC(Cours coursEC) {
		this.coursEC = coursEC;
	}
	
	

}

