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
import com.intiformation.AppSchool.modele.Promotion;

@Repository
public class PromotionDAOImpl implements IPromotionDAO {
	
	
	// declaration de la session factory d'hibernate
	/**
	 * le conteneur spring va instancier pour nous un objet de type session factory
	 * et va l'injecter dans la prop "sessionFactory"
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * setter de la sessionfactory pour injection par modificateur de spring
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void add(Promotion pPromotion) {
		Session session = this.sessionFactory.getCurrentSession();
		
		try {

			// 3 ajout dans la bdd via la session
			session.save(pPromotion);

			

		} catch (HibernateException e) {

			// cas erreur
			System.out.println("erreur dans la dao pour l'ajout de Promotion");
			
			throw e;

		} // end catch

	}//end ajout

	@Override
	@Transactional
	public void update(Promotion pPromotion) {


		// 1. recup de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		// 2. recup + ouverture d'une tx via la session
		

		try {

			// 3 modif dans la bdd via la session
			session.update(pPromotion);

			// 4 validation
			

		} catch (HibernateException e) {

			// cas erreur
			System.out.println("erreur dans la dao pour la modif de la promotion");
			
			throw e;

		} // end catch

	}//end  modif

	@Override
	@Transactional
	public void delete(Integer idPromotion) {

		// 1. recup de la session d'hibernate via la factory
					Session session = this.sessionFactory.getCurrentSession();

					// 2. recup + ouverture d'une tx via la session
					

					try {
						// 3 recup de l'employe à supprimer via son id
						Promotion promotionDelete = getById(idPromotion);

						// 3 ajout dans la bdd via la session
						session.delete(promotionDelete);

						// 4 validation
					

					} catch (HibernateException e) {

						// cas erreur
						System.out.println("erreur dans la dao pour la suppression de la promotion");
						
						throw e;

					} // end catch
		
	}//end delete

	@Override
	@Transactional(readOnly=true)
	public List<Promotion> getAll() {
		try {
			Session session = this.sessionFactory.getCurrentSession();

			Query<Promotion> query = session.createQuery("From Promotion");

			// 3 envoie + exce +resul
			List<Promotion> listePromotionBDD = query.getResultList();

			return listePromotionBDD;
		} catch (Exception e) {
			System.out.println("PromotionDAOImpl erreur lors de la liste des Promotions dans la bdd");
			throw e;
		} // end catch
	}//end getall

	@Override
	@Transactional(readOnly=true)
	public Promotion getById(Integer idPromotion) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Promotion emp = session.find(Promotion.class, idPromotion);

			return emp;
		} catch (Exception e) {
			System.out.println("PromotionDAOImpl erreur lors deu getbyid");
			throw e;
		} // end catch
	}//end getbyId

	
	
	@Override
	@Transactional
	public List<Promotion> getListNotLinkedToEtudiant(int pIdEtudiant) {
		
		Session session = this.sessionFactory.getCurrentSession();

		//Construction de la requete
		String RequeteListNotLinkedToEtudiant = "select p from Promotion p where p.idPromotion not in ( select p.idPromotion from Promotion p join p.listeEtudiants e where e.identifiant=:pIdEtudiant)";
		Query<Promotion> listQuery = session.createQuery(RequeteListNotLinkedToEtudiant);
		
		//Passage de param
		listQuery.setParameter("pIdEtudiant", pIdEtudiant);
		
		// envoi + exec + resultat
		List<Promotion> listePromo =listQuery.getResultList();
		
		return listePromo;
	}

	@Override
	@Transactional
	public List<Etudiant> getListNotLinkedToPromotion(int pIdPromotion) {
		Session session = this.sessionFactory.getCurrentSession();

		//Construction de la requete
		String RequeteListNotLinkedToPromotion = "select e from Etudiant e where e.identifiant not in ( select e.identifiant from Etudiant e join e.listePromotions p where p.idPromotion=:pIdPromotion)";
		Query<Etudiant> listQuery = session.createQuery(RequeteListNotLinkedToPromotion);
		
		//Passage de param
		listQuery.setParameter("pIdPromotion", pIdPromotion);
		
		// envoi + exec + resultat
		List<Etudiant> listeEtudiant =listQuery.getResultList();
		
		return listeEtudiant;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Etudiant> getListEtudiantByIdPromo(int pIdPromotion) {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<Etudiant> query = session.createQuery("select p.listeEtudiants FROM Promotion p where p.idPromotion=:idPromo");

			query.setParameter("idPromo", pIdPromotion);
			
			// 3. Envoi + Execution + Resultat
			List<Etudiant> listeEtudiant = query.getResultList();

			// 4. renvoi de la liste
			return listeEtudiant;

		} catch (Exception e) {

			System.out.println("... (EtudiantDAOImpl) Erreur lors de la récupération de la liste des promotions ....");

		} // end catch
		return null;
	}

	@Override
	@Transactional
	public List<Promotion> getListNotLinkedToCours(int pIdCours) {
		Session session = this.sessionFactory.getCurrentSession();

		//Construction de la requete
		String RequeteListNotLinkedToCours = "select p from Promotion p where p.idPromotion not in ( select p.idPromotion from Promotion p join p.listeCours c where c.idCours=:pIdCours)";
		Query<Promotion> listQuery = session.createQuery(RequeteListNotLinkedToCours);
		
		//Passage de param
		listQuery.setParameter("pIdCours", pIdCours);
		
		// envoi + exec + resultat
		List<Promotion> listePromo =listQuery.getResultList();
		
		return listePromo;
	}

	@Override
	@Transactional
	public List<Cours> getListNotLinkedToPromotionCours(int pIdPromotion) {
		Session session = this.sessionFactory.getCurrentSession();

		//Construction de la requete
		String RequeteListNotLinkedToPromotionCours = "select c from Cours c where c.idCours not in ( select c.idCours from Cours c join c.promotion p where p.idPromotion=:pIdPromotion)";
		Query<Cours> listQuery = session.createQuery(RequeteListNotLinkedToPromotionCours);
		
		//Passage de param
		listQuery.setParameter("pIdPromotion", pIdPromotion);
		
		// envoi + exec + resultat
		List<Cours> listeCours =listQuery.getResultList();
		
		return listeCours;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cours> getListCoursByIdPromo(int pIdPromotion) {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<Cours> query = session.createQuery("select p.listeCours FROM Promotion p where p.idPromotion=:idPromo");

			query.setParameter("idPromo", pIdPromotion);
			
			// 3. Envoi + Execution + Resultat
			List<Cours> listeCours = query.getResultList();

			// 4. renvoi de la liste
			return listeCours;

		} catch (Exception e) {

			System.out.println("... Erreur lors getListCoursByIdPromo ....");

		} // end catch
		return null;
	}
	
	

}//end class
