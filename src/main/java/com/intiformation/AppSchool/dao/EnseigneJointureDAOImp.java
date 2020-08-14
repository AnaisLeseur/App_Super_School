package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.AppSchool.modele.EnseigneJointure;

@Repository
public class EnseigneJointureDAOImp implements IEnseigneJointureDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void add(EnseigneJointure enseigneJointure) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Ajout dans la BDD
			session.save(enseigneJointure);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EnseigneJointureDAOImp) Erreur lors de l'ajout ....");

		} // end catch
	}

	@Override
	@Transactional
	public void update(EnseigneJointure enseigneJointure) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Modification dans la BDD
			session.update(enseigneJointure);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EnseigneJointureDAOImp) Erreur lors de la modification ....");

		} // end catch
	}

	@Override
	@Transactional
	public void delete(Integer idEnseigneJointure) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Recuperation de l'adresse à supprimer
			EnseigneJointure EnseigneJointureToDelete = getById(idEnseigneJointure);

			// 3. Suppression dans la BDD
			session.delete(EnseigneJointureToDelete);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (EnseigneJointureDAOImp) Erreur lors de la suppression ....");

		} // end catch
	}

	@Override
	@Transactional(readOnly=true)
	public List<EnseigneJointure> getAll() {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<EnseigneJointure> query = session.createQuery("FROM EnseigneJointure");

			// 3. Envoi + Execution + Resultat
			List<EnseigneJointure> listeEnseigneJointuresBDD = query.getResultList();

			// 4. renvoi de la liste
			return listeEnseigneJointuresBDD;

		} catch (Exception e) {

			System.out.println(
					"... (EnseigneJointureDAOImp) Erreur lors de la récupération de la liste des enseigneJointure ....");

		} // end catch
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public EnseigneJointure getById(Integer idEnseigneJointure) {
		try {

			Session session = this.sessionFactory.getCurrentSession();

			EnseigneJointure enseigneJointure = session.find(EnseigneJointure.class, idEnseigneJointure);

			return enseigneJointure;

		} catch (Exception e) {

			System.out.println("... (EnseigneJointureDAOImp) Erreur lors de la récup d'un étudiant via son id ....");

		} // end catch
		return null;
	}

	@Override
	@Transactional(readOnly=true)
	public boolean alreadyExist(int idEns, int idMat, int idPromo) {
		try {

			Session session = this.sessionFactory.getCurrentSession();

			Query<EnseigneJointure> query = session.createQuery("select ej FROM EnseigneJointure ej join ej.enseignantEJ e join ej.matiereEJ m join ej.promotionEJ p where e.identifiant=:idEns and m.idMatiere=:idMat and p.idPromotion=:idPromo");
			
			query.setParameter("idEns", idEns);
			query.setParameter("idMat", idMat);
			query.setParameter("idPromo", idPromo);
			
			List<EnseigneJointure> listeEnseigneJointuresBDD = query.getResultList();

			// 4. renvoi de la liste
			return listeEnseigneJointuresBDD.size()!=0;

		} catch (Exception e) {

			System.out.println(
					"... (EnseigneJointureDAOImp) Erreur lors de la vérif pour le validator ....");

		} // end catch
		return false;
	}

}
