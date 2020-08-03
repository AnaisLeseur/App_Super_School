package com.intiformation.AppSchool.service;

import java.util.List;

/**
 * interface générique de base de la couche Service. 
 * interface de base pour tous type de Service.
 * les methode déclarées seront communes à tous types de Service.
 * interface de type <T> car type générique
 *
 * @author anais
 *
 * @param <T>
 */
public interface IUniverselService<T> {
	
	/**
	 * permet d'ajouter tout type d'objet dans la bdd via la DAO.
	 * @param t : objet à ajouter
	 */
	public void ajouter(T t);

	/**
	 * permet de modifier tout type d'objet dans la bdd via la dao.
	 * @param t : objet à modifier
	 */
	public void modifier(T t);

	/**
	 * permet de suprimer tout type d'objet dans la bdd via la dao.
	 * @param id : id de l'objet à supprimer
	 */
	public void supprimer(Integer id);

	/**
	 * permet de récupérer la liste de tout type d'objet depuis la bdd via la dao.
	 * @return : la liste des objets
	 */
	public List<T> findAll();

	/**
	 * permet de récupérer tout type d'objet via son id (pk) depuis la bdd via la dao.
	 * @param id : l'id de l'objet à récupérer
	 * @return : l'objet
	 */
	public T findById(Integer id);

}// end interface
