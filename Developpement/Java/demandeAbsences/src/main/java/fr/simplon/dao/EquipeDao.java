<<<<<<< HEAD
package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Equipe;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name nom
	 * @return liste de equipes
	 */
	@Query("from Equipe where nom like %?1%")
	public List<Equipe> findEquipe(String nom);

}
=======
package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Equipe;

@Repository
public interface EquipeDao extends JpaRepository<Equipe, Long> {
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name nom
	 * @return liste de equipes
	 */
	@Query("from Equipe where nom like %?1%")
	public List<Equipe> findEquipe(String nom);

}
>>>>>>> master
