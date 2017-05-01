package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
	
	/**
	 * exemple de lecture personnalisee dans la base de donnees
	 * @param name role
	 * @return liste de roles
	 */
	@Query("from Role where role like %?1%")
	public Iterable<Role> findNewRoles(String role);

}
