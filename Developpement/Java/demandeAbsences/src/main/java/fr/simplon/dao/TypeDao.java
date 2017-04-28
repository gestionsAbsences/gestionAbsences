package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;

import fr.simplon.domain.Type;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public class TypeDao extends CrudRepository<Type, Long> {
	
	/**
	 * recherche d'un type dont le nom ou prenom contient la zone de recherche
	 * @param nom
	 * @return liste de types
	 */
	public Iterable<Type> findByNom(String nom);
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name nom
	 * @return liste de types
	 */
	@Query("from Type where nom like %?1%")
	public Iterable<Type> findNewTypes(String nom);

}
