package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Long>{

	/**
	 * lecture personnalisee dans la base de donnees
	 * @param role 
	 * @return nom service
	 */
	@Query("from Role where role = ?1")
	public Iterable<Role> findByRole(String role);

//	public Iterable<Role> findNewRoles(String role);

}
