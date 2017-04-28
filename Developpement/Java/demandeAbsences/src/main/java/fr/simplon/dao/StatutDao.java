package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.simplon.domain.Statut;

public interface StatutDao extends CrudRepository<Statut, Long>{
	 
	@Query("from Statut where code like %?1% ")
	public Iterable<Statut> findStatut(String name);

}


