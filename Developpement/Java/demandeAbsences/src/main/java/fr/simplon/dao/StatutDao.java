package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Statut;

@Repository
public interface StatutDao extends CrudRepository<Statut, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return nom service STATUT
	 */
	@Query("from Statut where Nom like %?1%")
	public Iterable<Statut> findByName(String name);
	
}
