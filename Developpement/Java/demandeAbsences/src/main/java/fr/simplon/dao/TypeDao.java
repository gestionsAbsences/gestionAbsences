package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.simplon.domain.TypeAbsence;



public interface TypeDao extends CrudRepository<TypeAbsence, Long> {
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name nom
	 * @return liste de types
	 */
	@Query("from TypeAbsence where nom like %?1%")
	public Iterable<TypeAbsence> findNewTypes(String nom);

}
