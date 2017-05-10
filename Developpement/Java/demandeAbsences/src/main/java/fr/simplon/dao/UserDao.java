package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.User;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return email service USER
	 */
	@Query("from User where email like %?1%")
	public Iterable<User> findByName(String email);
	
}
