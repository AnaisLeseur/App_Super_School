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


@Repository
public class CoursDAOImpl implements ICoursDAO {

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

	
	@Transactional
	@Override
	public void add(Cours pCours) {


		// 1. recup de la session d'hibernate via la factory
				Session session = this.sessionFactory.getCurrentSession();

				

				try {

					// 3 ajout dans la bdd via la session
					session.save(pCours);

					

				} catch (HibernateException e) {

					// cas erreur
					System.out.println("erreur dans la dao pour l'ajout du cours");
					
					throw e;

				} // end catch

			}// end add Cours
	

	@Transactional
	@Override
	public void update(Cours pCours) {
		
		// 1. recup de la session d'hibernate via la factory
				Session session = this.sessionFactory.getCurrentSession();

				// 2. recup + ouverture d'une tx via la session
				

				try {

					// 3 modif dans la bdd via la session
					session.update(pCours);

					// 4 validation
					

				} catch (HibernateException e) {

					// cas erreur
					System.out.println("erreur dans la dao pour la modif du cours");
					
					throw e;

				} // end catch
		
	}//end updateCours

	@Transactional
	@Override
	public void delete(Integer pIdCours) {
		// 1. recup de la session d'hibernate via la factory
				Session session = this.sessionFactory.getCurrentSession();

				// 2. recup + ouverture d'une tx via la session
				

				try {
					// 3 recup de l'employe à supprimer via son id
					Cours coursDelete = getById(pIdCours);

					// 3 ajout dans la bdd via la session
					session.delete(coursDelete);

					// 4 validation
				

				} catch (HibernateException e) {

					// cas erreur
					System.out.println("erreur dans la dao pour la suppression du cours");
					
					throw e;

				} // end catch
	}//end deleteCours

	@Transactional(readOnly=true)
	@Override
	public List<Cours> getAll() {
		try {
			Session session = this.sessionFactory.getCurrentSession();

			Query query = session.createQuery("From Cours");

			// 3 envoie + exce +resul
			List<Cours> listeCoursBDD = query.list();

			return listeCoursBDD;
		} catch (Exception e) {
			System.out.println("CoursDAOImpl erreur lors de la liste des cours dans la bdd");
			throw e;
		} // end catch
	}//listeCours

	@Transactional(readOnly=true)
	@Override
	public Cours getById(Integer pIdCours) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			Cours emp = session.find(Cours.class, pIdCours);

			return emp;
		} catch (Exception e) {
			System.out.println("EmployeeDAOImpl erreur lors deu getbyid");
			throw e;
		} // end catch
	}//end getById

}//end class
