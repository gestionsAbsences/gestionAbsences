package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.TypeAbsence;

@Repository
public interface TypeDao extends CrudRepository<TypeAbsence, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return nom service RH
	 */
	@Query("from TypeAbsence where nom like %?1%")
	public Iterable<TypeAbsence> findByName(String name);
	
}
