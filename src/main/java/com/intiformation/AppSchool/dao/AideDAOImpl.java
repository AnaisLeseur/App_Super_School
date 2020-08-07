package com.intiformation.AppSchool.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.AppSchool.modele.Aide;
import com.intiformation.AppSchool.modele.Matiere;

@Transactional
@Repository
public class AideDAOImpl implements IAideDAO {

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
	public void add(Aide pAide) {
		// 1. recup de la session d'hibernate via la factory
					Session session = this.sessionFactory.getCurrentSession();

					

					try {

						// 3 ajout dans la bdd via la session
						session.save(pAide);

						

					} catch (HibernateException e) {

						// cas erreur
						System.out.println("erreur dans la dao pour l'ajout de l'aide");
						
						throw e;

					} // end catch
	}//end add

	@Override
	public void update(Aide pAide) {
		// 1. recup de la session d'hibernate via la factory
		Session session = this.sessionFactory.getCurrentSession();

		

		try {

			// 3 ajout dans la bdd via la session
			session.update(pAide);

			

		} catch (HibernateException e) {

			// cas erreur
			System.out.println("erreur dans la dao pour la modification de l'aide");
			
			throw e;

		} // end catch
	}//end update

	@Override
	public void delete(Integer IdAide) {


		// 1. recup de la session d'hibernate via la factory
					Session session = this.sessionFactory.getCurrentSession();

					// 2. recup + ouverture d'une tx via la session
					

					try {
						// 3 recup de l'employe à supprimer via son id
						Aide aideDelete = getById(IdAide);

						// 3 ajout dans la bdd via la session
						session.delete(aideDelete);

						// 4 validation
					

					} catch (HibernateException e) {

						// cas erreur
						System.out.println("erreur dans la dao pour la suppression de l'aide");
						
						throw e;

					} // end catch
		
	}//end delelte

	@Override
	public List<Aide> getAll() {
		try {
			Session session = this.sessionFactory.getCurrentSession();

			Query query = session.createQuery("From Aide");

			// 3 envoie + exce +resul
			List<Aide> listeAideBDD = query.list();

			return listeAideBDD;
		} catch (Exception e) {
			System.out.println("MatiereDAOImpl erreur lors de la liste des aide dans la bdd");
			throw e;
		} // end catch
	}//end getAll

	@Override
	public Aide getById(Integer IdAide) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Aide aide = session.find(Aide.class, IdAide);

			return aide;
		} catch (Exception e) {
			System.out.println("AideDAOImpl erreur lors deu getbyid");
			throw e;
		} // end catch
	}//end byId

}//end class
