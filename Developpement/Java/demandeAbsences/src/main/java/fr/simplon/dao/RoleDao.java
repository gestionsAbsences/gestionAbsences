package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return nom service RH
	 */
	@Query("from Role where valeur like %?1%")
	public Iterable<Role> findByName(String name);
	
}
