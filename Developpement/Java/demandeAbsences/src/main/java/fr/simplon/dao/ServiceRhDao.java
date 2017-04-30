package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.ServiceRh;

@Repository
public interface ServiceRhDao extends CrudRepository<ServiceRh, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return nom service RH
	 */
	@Query("from ServiceRh where Nom like %?1%")
	public Iterable<ServiceRh> findByName(String name);
	
	@Query("from ServiceRh where Email like %?1%")
	public Iterable<ServiceRh> findByEmail(String email);
	
}
