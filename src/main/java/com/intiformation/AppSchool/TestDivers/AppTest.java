package com.intiformation.AppSchool.TestDivers;

import java.util.Calendar;
import java.util.Date;

import com.intiformation.AppSchool.modele.Administrateur;
import com.intiformation.AppSchool.modele.Etudiant;

public class AppTest {

	public static void main(String[] args) {

		// 1. etudiant a ajouter
		Date date = new Calendar.Builder().setDate(1999, 12, 22);
		Etudiant etudiant1 = new Etudiant("motDePasse", "nom", "prenom", "email", "photo", dateNaissance)

		// 2.formateur a ajouter
		Administrateur admin1 = new Enseignant("Paul Pierre", "Dev Back-end");

		// 3.recup de l'EM
		EntityManager em = Persistence.createEntityManagerFactory("PU__Heritage_JPA").createEntityManager();

		// 4.transaction
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// 5.ajout dans la bdd
		em.persist(apprenant1);
		em.persist(enseignant1);

		// 6.validation de la tx
		tx.commit();

		// Fermeture de la ressource
		em.close();
	}

}
