package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

			}// end add employe
	

	@Override
	public void update(Cours t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cours> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cours getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}//end class
