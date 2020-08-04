package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.intiformation.AppSchool.modele.Matiere;

@Repository
public class MatiereDAOImpl implements IMatiereDAO {

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
		public void add(Matiere pMatiere) {

			// 1. recup de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			

			try {

				// 3 ajout dans la bdd via la session
				session.save(pMatiere);

				

			} catch (HibernateException e) {

				// cas erreur
				System.out.println("erreur dans la dao pour l'ajout de Matiere");
				
				throw e;

			} // end catch

		}// end add matiere
		

		@Transactional
		@Override
		public void update(Matiere pMatiere) {

			// 1. recup de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. recup + ouverture d'une tx via la session
			

			try {

				// 3 modif dans la bdd via la session
				session.update(pMatiere);

				// 4 validation
				

			} catch (HibernateException e) {

				// cas erreur
				System.out.println("erreur dans la dao pour la modif de la matiere");
				
				throw e;

			} // end catch
			
		}//end updateMatiere

		@Transactional
		@Override
		public void delete(Integer IdMatiere) {
			// 1. recup de la session d'hibernate via la factory
			Session session = this.sessionFactory.getCurrentSession();

			// 2. recup + ouverture d'une tx via la session
			

			try {
				// 3 recup de l'employe à supprimer via son id
				Matiere matiereDelete = getById(IdMatiere);

				// 3 ajout dans la bdd via la session
				session.delete(matiereDelete);

				// 4 validation
			

			} catch (HibernateException e) {

				// cas erreur
				System.out.println("erreur dans la dao pour la suppression de la matiere");
				
				throw e;

			} // end catch
		}//end Matieredelete

		@Override
		public List<Matiere> getAll() {
			try {
				Session session = this.sessionFactory.getCurrentSession();

				Query query = session.createQuery("From Employe");

				// 3 envoie + exce +resul
				List<Matiere> listeMatiereBDD = query.list();

				return listeMatiereBDD;
			} catch (Exception e) {
				System.out.println("MatiereDAOImpl erreur lors de la liste des Matiere dans la bdd");
				throw e;
			} // end catch
		}//end listeMatiere

		@Override
		public Matiere getById(Integer IdMatiere) {
			try {
				Session session = this.sessionFactory.getCurrentSession();
				Matiere emp = session.find(Matiere.class, IdMatiere);

				return emp;
			} catch (Exception e) {
				System.out.println("EmployeeDAOImpl erreur lors deu getbyid");
				throw e;
			} // end catch
		}

	
}//end class
