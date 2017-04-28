package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.simplon.domain.Type;

public interface TypeDao extends CrudRepository<Type, Long> {

	@Query("from Type where Nom like %?1%")
	public Iterable<Type> findNewTypes(String nom);

}
