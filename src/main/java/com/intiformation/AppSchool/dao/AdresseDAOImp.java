package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.AppSchool.modele.Adresse;

@Repository
public class AdresseDAOImp implements IAdresseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void add(Adresse pAdresse) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Ajout dans la BDD
			session.save(pAdresse);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (AdresseDAOImp) Erreur lors de l'ajout ....");

		} // end catch

	}//end add()

	@Override
	@Transactional
	public void update(Adresse pAdresse) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Modification dans la BDD
			session.update(pAdresse);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (AdresseDAOImp) Erreur lors de la modification ....");
			
		} // end catch

	}//end update()

	@Override
	public void delete(Integer idAdresse) {
		// 1. Recuperation de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		try {

			// 2. Recuperation de l'adresse à supprimer
			Adresse adresseToDelete = getById(idAdresse);

			// 3. Suppression dans la BDD
			session.delete(adresseToDelete);

		} catch (HibernateException e) {

			// cas erreur : annulation de la transaction
			System.out.println("... (AdresseDAOImp) Erreur lors de la suppression ....");
			
		} // end catch

	}

	@Override
	@Transactional(readOnly = true)
	public List<Adresse> getAll() {
		try {

			// 1. Recuperation de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. Definition de la requête à envoyer
			Query<Adresse> query = session.createQuery("FROM Adresse");

			// 3. Envoi + Execution + Resultat
			List<Adresse> listeAdressesBDD = query.getResultList();

			// 4. renvoi de la liste
			return listeAdressesBDD;

		} catch (Exception e) {
			
			System.out.println("... (AdresseDAOImpl) Erreur lors de la récupération de la liste des adresses ....");
			
		} // end catch
		
		return null;
		
	}//end getAll()
	
	

	@Override
	@Transactional(readOnly = true)
	public Adresse getById(Integer idAdresse) {
		try {

			Session session = this.sessionFactory.getCurrentSession();
			Adresse adresse = session.find(Adresse.class, idAdresse);

			return adresse;

		} catch (Exception e) {
			
			System.out.println("... (AdresseDAOImp) Erreur lors de la récup d'une adresse via son id ....");
			
		} // end catch
		
		return null;
	}//end getById()
	
	//Setter

	/**
	 * Setter pour injection par modificateur
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}//end class
