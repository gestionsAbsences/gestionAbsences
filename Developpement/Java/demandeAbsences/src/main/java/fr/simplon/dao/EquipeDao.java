package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Equipe;

@Repository
public interface EquipeDao extends CrudRepository<Equipe, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return nom service RH
	 */
	@Query("from Equipe where Nom like %?1%")
	public Iterable<Equipe> findByName(String name);
	
}
