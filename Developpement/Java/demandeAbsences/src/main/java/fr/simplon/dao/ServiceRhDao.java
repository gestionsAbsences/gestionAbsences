package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.simplon.domain.ServiceRh;


public interface ServiceRhDao extends CrudRepository<ServiceRh, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return liste service RH
	 */
	@Query("from ServiceRh where Nom like %?1%")
	public Iterable<ServiceRh> findServiceRh(String name);


}
