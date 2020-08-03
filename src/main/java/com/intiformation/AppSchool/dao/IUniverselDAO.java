package com.intiformation.AppSchool.dao;

import java.util.List;



public interface IUniverselDAO<T> {


	
// récup d'une connexion vers la bdd via l'utilitaire ConnexionBdd


// déclaration des méthodes à exposer dans la DAO
/**
 * permet d'ajouter tout type d'objet dans la bdd.
 * @param t : objet à ajouter
 * @return true si ajout ok sinon false
 */
public void add(T t);

/**
 * permet de modifier tout type d'objet dans la bdd.
 * @param t : objet à modifier
 * @return true si modification ok sinon false
 */
public void update(T t);

/**
 * permet de suprimer tout type d'objet dans la bdd.
 * @param id : id de l'objet à supprimer
 * @return : true si suppression OK, sinon false
 */
public void delete(Integer id);

/**
 * permet de récupérer la liste de tout type d'objet depuis la bdd.
 * @return : la liste des objets
 */
public List<T> getAll();

/**
 * permet de récupérer tout type d'objet via son id (pk) depuis la bdd.
 * @param id : l'id de l'objet à récupérer
 * @return : l'objet
 */
public T getById(Integer id);
	
}
