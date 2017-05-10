package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Employe;

@Repository
public interface EmployeDao extends CrudRepository<Employe, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return nom service EMPLOYE
	 */
	@Query("from Employe where Nom like %?1%")
	public Iterable<Employe> findByName(String name);
	
}
