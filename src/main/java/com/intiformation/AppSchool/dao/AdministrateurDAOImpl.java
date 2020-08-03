package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.AppSchool.modele.Administrateur;


/**
 * Implémentation concrète de la couche DAO pour un administrateur 
 * Implémente l'interface IAdministrateurDAO
 * 
 * @author anais
 *
 */
@Repository // déclaration de la classe comme bean de spring
public class AdministrateurDAOImpl implements IAdministrateurDAO {

		// déclaration de la sessionFactory d'Hibernate
		@Autowired // injection par type 
		private SessionFactory sessionFactory;
		
		/**
		 * 	setteur de sessionFactory pour l'injection par modificateur de spring
		 * @param sessionFactory
		 */
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		
	/**
	 * =====================================
	 * Ajouter un administrateur dans la bdd
	 * =====================================
	 */
	@Override
	@Transactional
	public void add(Administrateur pAdminsitrateur) {
		
		// 1. récup de la session d'hibernate 
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
			// 2. ajout dans la bdd via la session et la meth save()
			session.save(pAdminsitrateur);
			
		} catch (HibernateException e) {
			
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de l'ajout dans AdministrateurDAOImpl !!");
			
		}// end catch
	}// end add()
	
	
	
	
	/**
	 * ======================================
	 * Modifier un administrateur dans la bdd
	 * ======================================
	 */
	@Override
	@Transactional
	public void update(Administrateur pAdminsitrateur) {
		
		// 1. récup de la session d'hibernate 
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
			// 2. modif dans la bdd via la session et la meth update()
			session.update(pAdminsitrateur);
			
		} catch (HibernateException e) {
			
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la modification dans AdministrateurDAOImpl !!");
			
		}// end catch
		
	}// end update

	
	
	/**
	 * =====================================
	 * Supprimer un administrateur de la bdd
	 * =====================================
	 */
	@Override
	@Transactional
	public void delete(Integer pIdAdministrateur) {
		// 1. récup de la session d'hibernate 
		Session session = this.sessionFactory.getCurrentSession();

		try {
			// 2. récup de l'administrateur à supprimer via son id 
			Administrateur adminToDelete = getById(pIdAdministrateur);
			
			// 3. suppression dans la bdd via la session et la meth delete()
			session.delete(adminToDelete);
			
		} catch (HibernateException e) {
			
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la suppression dans AdministrateurDAOImpl !!");
			
		}// end catch

	}// end delete

	
	/**
	 * ======================================================
	 * Récupération de la liste des administrateurs de la bdd
	 * ======================================================
	 */
	@Override
	@Transactional(readOnly=true) // readOnly=true => optimisation de la tx 
	public List<Administrateur> getAll() {
		
		try {
			// 1. session d'hibernate
			Session session = this.sessionFactory.getCurrentSession();
			
			// 2. def de la Rqt à envoyer (HQL) 
			Query query = session.createQuery("FROM Administrateur");
			
			// 3. envoi + exec + resultat
			List<Administrateur> listeAdminBdd = query.getResultList();
			
			// 4 renvoi de la liste 
			return listeAdminBdd;
			
		} catch (Exception e) {
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la récupération de la liste des administrateurs dans AdministrateurDAOImpl !!");
			throw e;	
			
		}// end catch
	}// end getAll

	
	/**
	 * ===========================================
	 * Récupération d'un administrateur par son Id
	 * ===========================================
	 */
	@Override
	@Transactional(readOnly=true) // readOnly=true => optimisation de la tx 
	public Administrateur getById(Integer pIdAdministrateur) {
		
		try {
			// 1. session d'hibernate
			Session session = this.sessionFactory.getCurrentSession();
			
			// 2. récup de l'admin via son Id
			Administrateur admin = session.find(Administrateur.class, pIdAdministrateur);
			return admin;
			
		} catch (Exception e) {
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la récupération de l'administrateur (getById) dans AdministrateurDAOImpl !!");
			throw e;
						
		}// end catch
	}// end getById

}// end class
