package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Equipe;

@Repository
public interface EquipeDao extends CrudRepository<Equipe, Long> {
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name nom
	 * @return liste de equipes
	 */
	@Query("from Equipe where nom like %?1%")
	public Iterable<Equipe> findNewEquipes(String nom);

}
