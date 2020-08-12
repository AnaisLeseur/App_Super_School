package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.AppSchool.modele.Cours;
import com.intiformation.AppSchool.modele.Etudiant;
import com.intiformation.AppSchool.modele.EtudiantCours;
import com.intiformation.AppSchool.modele.Promotion;

@Repository
public class EtudiantDAOImp implements IEtudiantDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Setter pour injection par modificateur
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Override
	@Transactional
	public void add(Etudiant pEtudiant) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Ajout dans la BDD
			session.save(pEtudiant);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EtudiantDAOImp) Erreur lors de l'ajout ....");

		} // end catch
	}

	@Override
	@Transactional
	public void update(Etudiant pEtudiant) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Modification dans la BDD
			session.update(pEtudiant);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EtudiantDAOImp) Erreur lors de la modification ....");

		} // end catch
	}

	@Override
	@Transactional
	public void delete(Integer idEtudiant) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Recuperation de l'adresse à supprimer
			Etudiant EtudiantToDelete = getById(idEtudiant);

			// 3. Suppression dans la BDD
			session.delete(EtudiantToDelete);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EtudiantDAOImp) Erreur lors de la suppression ....");

		} // end catch
	}

	@Override
	@Transactional(readOnly = true)
	public List<Etudiant> getAll() {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<Etudiant> query = session.createQuery("FROM Etudiant");

			// 3. Envoi + Execution + Resultat
			List<Etudiant> listeEtudiantsBDD = query.getResultList();

			// 4. renvoi de la liste
			return listeEtudiantsBDD;

		} catch (Exception e) {

			System.out.println("... (EtudiantDAOImpl) Erreur lors de la récupération de la liste des étudiants ....");

		} // end catch
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Etudiant getById(Integer idEtudiant) {
		try {

			Session session = this.sessionFactory.getCurrentSession();

			Etudiant etudiant = session.find(Etudiant.class, idEtudiant);

			return etudiant;

		} catch (Exception e) {

			System.out.println("... (EtudiantDAOImp) Erreur lors de la récup d'un étudiant via son id ....");

		} // end catch
		return null;
	}

	@Override
	@Transactional
	public Etudiant addReturnEtudiant(Etudiant pEtudiant) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Ajout dans la BDD
			session.save(pEtudiant);
			session.flush();
			return pEtudiant;

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EtudiantDAOImp) Erreur lors de l'ajout ....");

		} // end catch
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Promotion> getListPromoByIdEtudiant(int pIdEtudiant) {
		
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<Promotion> query = session.createQuery("select e.listePromotions FROM Etudiant e where e.identifiant=:identifiant");

			query.setParameter("identifiant", pIdEtudiant);
			
			// 3. Envoi + Execution + Resultat
			List<Promotion> listePromoByEtudiant = query.getResultList();

			// 4. renvoi de la liste
			return listePromoByEtudiant;

		} catch (Exception e) {

			System.out.println("... (EtudiantDAOImpl) Erreur lors de la récupération de la liste des promotions ....");

		} // end catch
		return null;
	}


	@Override
	@Transactional(readOnly = true)
	public List<Cours> getListCoursNotLinkedToEtudiant(int pIdEtudiant) {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<Cours> query = session.createQuery("select c from Cours c where c.idCours not in (select c.idCours from Cours c join c.listeEtudiantsCours ec join ec.etudiantEC e where e.identifiant=:idEtudiant)");

			query.setParameter("idEtudiant", pIdEtudiant);
			
			// 3. Envoi + Execution + Resultat
			List<Cours> listeCours = query.getResultList();

			// 4. renvoi de la liste
			return listeCours;

		} catch (Exception e) {

			System.out.println("... (EtudiantDAOImpl) Erreur lors de la récupération de la liste des promotions ....");

		} // end catch
		return null;
	}


	@Override
	@Transactional(readOnly = true)
	public List<EtudiantCours> getListEtudiantCoursByIdEtudiant(int pIdEtudiant) {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<EtudiantCours> query = session.createQuery("select e.listeEtudiantCours FROM Etudiant e where e.identifiant=:identifiant");

			query.setParameter("identifiant", pIdEtudiant);
			
			// 3. Envoi + Execution + Resultat
			List<EtudiantCours> listeEtudiantCours = query.getResultList();

			// 4. renvoi de la liste
			return listeEtudiantCours;

		} catch (Exception e) {

			System.out.println("... (EtudiantDAOImpl) Erreur lors de la récupération de la liste des EtudiantCours ....");

		} // end catch
		return null;
	}

}// end class
