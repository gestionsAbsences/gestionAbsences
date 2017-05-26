package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.ServiceRh;

@Repository
public interface ServiceRhDao extends JpaRepository<ServiceRh, Long>{
	
	/**
	 * lecture personnalisee dans la base de donnees
	 * @param name 
	 * @return nom service RH
	 */
	@Query("from ServiceRh where Nom like %?1%")
	public List<ServiceRh> findByName(String name);
	
	@Query("from ServiceRh where Email like %?1%")
	public List<ServiceRh> findByEmail(String email);
	
}
