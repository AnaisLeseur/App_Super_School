package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.intiformation.AppSchool.modele.Matiere;

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
		public void add(Matiere t) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void update(Matiere t) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Integer id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Matiere> getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Matiere getById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}

	
}//end class
