package com.intiformation.AppSchool.modele;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * table de jointure entre les classes: 
 * 	- Enseignant
 * 	- Promotion
 * 	- Matière
 * 
 * @author vincent
 *
 */
@Entity
public class EnseigneJointure implements Serializable {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "EnseigneJointure_matiere", referencedColumnName = "idMatiere")
	private Matiere matiere; 

	@Id
    @ManyToOne
    @JoinColumn(name = "EnseigneJointure_promotion", referencedColumnName = "idPromotion")
	private Promotion promotion; 
	
	@Id
    @ManyToOne
    @JoinColumn(name = "EnseigneJointure_enseignant", referencedColumnName = "identifiant")
	private Enseignant enseignant;

	
	
	// ---- Getters / Setters ----

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}


}// end class
