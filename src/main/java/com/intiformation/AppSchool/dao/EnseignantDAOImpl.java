package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.AppSchool.modele.Enseignant;

/**
* Implémentation concrète de la couche DAO pour un enseignant 
* Implémente l'interface IEnseignantDAO
* 
* @author anais
*
*/
@Repository // déclaration de la classe comme bean de spring
public class EnseignantDAOImpl implements IEnseignantDAO {
	
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
	 * Ajouter un enseignant dans la bdd
	 * =====================================
	 */
	@Override
	@Transactional
	public void add(Enseignant pEnseignant) {
		// 1. récup de la session d'hibernate 
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
			// 2. ajout dans la bdd via la session et la meth save()
			session.save(pEnseignant);
			
		} catch (HibernateException e) {
			
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de l'ajout dans EnseignantDAOImpl !!");
			
		}// end catch
	}// end add

	
	/**
	 * ======================================
	 * Modifier un enseignant dans la bdd
	 * ======================================
	 */
	@Override
	@Transactional
	public void update(Enseignant pEnseignant) {
		// 1. récup de la session d'hibernate 
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
			// 2. modif dans la bdd via la session et la meth update()
			session.update(pEnseignant);
			
		} catch (HibernateException e) {
			
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la modification dans EnseignantDAOImpl !!");
			
		}// end catch	
	}// end update

	
	/**
	 * =====================================
	 * Supprimer un enseignant de la bdd
	 * =====================================
	 */
	@Override
	@Transactional
	public void delete(Integer pIdEnseignant) {
		// 1. récup de la session d'hibernate 
		Session session = this.sessionFactory.getCurrentSession();

		try {
			// 2. récup de l'enseignant à supprimer via son id 
			Enseignant enseignantToDelete = getById(pIdEnseignant);
			
			// 3. suppression dans la bdd via la session et la meth delete()
			session.delete(enseignantToDelete);
			
		} catch (HibernateException e) {
			
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la suppression dans EnseignantDAOImpl !!");
			
		}// end catch
	}// end delete

	
	/**
	 * ======================================================
	 * Récupération de la liste des enseignants de la bdd
	 * ======================================================
	 */
	@Override
	@Transactional(readOnly=true) // readOnly=true => optimisation de la tx 
	public List<Enseignant> getAll() {

		try {
			// 1. session d'hibernate
			Session session = this.sessionFactory.getCurrentSession();
			
			// 2. def de la Rqt à envoyer (HQL) 
			Query<Enseignant> query = session.createQuery("FROM Enseignant");
			
			// 3. envoi + exec + resultat
			List<Enseignant> listeEnseignantBdd = query.getResultList();
			
			// 4 renvoi de la liste 
			return listeEnseignantBdd;
			
		} catch (Exception e) {
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la récupération de la liste des administrateurs dans EnseignantDAOImpl !!");
			throw e;	
			
		}// end catch
	}// end getAll

	
	/**
	 * ===========================================
	 * Récupération d'un enseignant par son Id
	 * ===========================================
	 */
	@Override
	@Transactional(readOnly=true) // readOnly=true => optimisation de la tx 
	public Enseignant getById(Integer pIdEnseignant) {

		try {
			// 1. session d'hibernate
			Session session = this.sessionFactory.getCurrentSession();
			
			// 2. récup de l'admin via son Id
			Enseignant enseignant = session.find(Enseignant.class, pIdEnseignant);
			return enseignant;
			
		} catch (Exception e) {
			// cas erreur : annulation de la tx 
			System.out.println("\n ... Erreur lors de la récupération de l'enseignant (getById) dans EnseignantDAOImpl !!");
			throw e;
						
		}// end catch
	}// end getById

}// end class
