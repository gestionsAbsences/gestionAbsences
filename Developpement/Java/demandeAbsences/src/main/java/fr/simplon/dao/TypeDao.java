package fr.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.TypeAbsence;

@Repository
public interface TypeDao extends JpaRepository<TypeAbsence, Long> {
	
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name nom
	 * @return liste de types
	 */
	@Query("from TypeAbsence where nom like %?1%")
	public TypeAbsence findTypeByName(String nom);

}
