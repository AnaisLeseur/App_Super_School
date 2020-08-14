package com.intiformation.AppSchool.modele;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnseigneJointure;
	
    @ManyToOne
    @JoinColumn(name = "EnseigneJointure_matiere", referencedColumnName = "idMatiere")
	private Matiere matiereEJ; 

    @ManyToOne
    @JoinColumn(name = "EnseigneJointure_promotion", referencedColumnName = "idPromotion")
	private Promotion promotionEJ; 
	
    @ManyToOne
    @JoinColumn(name = "EnseigneJointure_enseignant", referencedColumnName = "identifiant")
	private Enseignant enseignantEJ;

	//Constructeurs
    
	public EnseigneJointure(Matiere matiereEJ, Promotion promotionEJ, Enseignant enseignantEJ) {
		this.matiereEJ = matiereEJ;
		this.promotionEJ = promotionEJ;
		this.enseignantEJ = enseignantEJ;
	}

	public EnseigneJointure(int idEnseigneJointure, Matiere matiereEJ, Promotion promotionEJ, Enseignant enseignantEJ) {
		this.idEnseigneJointure = idEnseigneJointure;
		this.matiereEJ = matiereEJ;
		this.promotionEJ = promotionEJ;
		this.enseignantEJ = enseignantEJ;
	}

	public EnseigneJointure() {
	}
	
	// ---- Getters / Setters ----

	public Matiere getMatiereEJ() {
		return matiereEJ;
	}

	public void setMatiereEJ(Matiere matiereEJ) {
		this.matiereEJ = matiereEJ;
	}

	public Promotion getPromotionEJ() {
		return promotionEJ;
	}

	public void setPromotionEJ(Promotion promotionEJ) {
		this.promotionEJ = promotionEJ;
	}

	public Enseignant getEnseignantEJ() {
		return enseignantEJ;
	}

	public void setEnseignantEJ(Enseignant enseignantEJ) {
		this.enseignantEJ = enseignantEJ;
	}

	public int getIdEnseigneJointure() {
		return idEnseigneJointure;
	}

	public void setIdEnseigneJointure(int idEnseigneJointure) {
		this.idEnseigneJointure = idEnseigneJointure;
	}
	
}// end class
