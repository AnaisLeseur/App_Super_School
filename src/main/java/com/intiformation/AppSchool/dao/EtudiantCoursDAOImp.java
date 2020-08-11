package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.AppSchool.modele.EtudiantCours;

public class EtudiantCoursDAOImp implements IEtudiantCoursDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void add(EtudiantCours etudiantCours) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Ajout dans la BDD
			session.save(etudiantCours);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EtudiantCoursDAOImp) Erreur lors de l'ajout ....");

		} // end catch
	}

	@Override
	@Transactional
	public void update(EtudiantCours etudiantCours) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Modification dans la BDD
			session.update(etudiantCours);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EtudiantCoursDAOImp) Erreur lors de la modification ....");

		} // end catch

	}

	@Override
	@Transactional
	public void delete(Integer idEtudiantCours) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Recuperation de l'adresse à supprimer
			EtudiantCours etudiantCoursToDelete = getById(idEtudiantCours);

			// 3. Suppression dans la BDD
			session.delete(etudiantCoursToDelete);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EtudiantCoursDAOImp) Erreur lors de la suppression ....");

		} // end catch
	}

	@Override
	@Transactional(readOnly = true)
	public List<EtudiantCours> getAll() {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer & Envoi + Execution + Resultat
			List<EtudiantCours> listeEtudiantsCours = session.createQuery("FROM EtudiantCours").getResultList();

			// 3. renvoi de la liste
			return listeEtudiantsCours;

		} catch (Exception e) {

			System.out.println(
					"... (EtudiantCoursDAOImp) Erreur lors de la récupération de la liste des étudiantcours ....");

		} // end catch
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public EtudiantCours getById(Integer idEtudiantCours) {
		try {

			Session session = this.sessionFactory.getCurrentSession();

			EtudiantCours etudiantCours = session.find(EtudiantCours.class, idEtudiantCours);

			return etudiantCours;

		} catch (Exception e) {

			System.out.println("... (EtudiantCoursDAOImp) Erreur lors de la récup d'un étudiant via son id ....");

		} // end catch
		return null;
	}

}//end class
