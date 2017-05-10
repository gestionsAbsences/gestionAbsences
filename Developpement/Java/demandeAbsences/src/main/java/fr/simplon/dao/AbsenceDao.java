package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Absence;

@Repository
public interface AbsenceDao extends CrudRepository<Absence, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param id 
	 * @return id service ABSENCE
	 */
	@Query("from Absence where id = ?1")
	public Iterable<Absence> findById(Long id);
	
}
