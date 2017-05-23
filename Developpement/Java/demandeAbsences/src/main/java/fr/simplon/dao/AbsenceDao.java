package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.simplon.domain.Absence;

/**
 * lecture personnalisée de la BDD
 * 
 * @author Simplon
 *
 */
public interface AbsenceDao extends JpaRepository<Absence, Long> {
	
	/**
	 * recherche d'une absence
	 * @param id 
	 * @return une absence
	 */
	@Query("from Absence where id = ?")
	public List<Absence> findById(Long id);
	
	

}
