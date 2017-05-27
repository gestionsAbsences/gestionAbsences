<<<<<<< HEAD
package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Employe;

/**
 * Interface du CRUD
 * 
 * @author JGL
 *
 */
@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {
	
	/**
	 * lecture personnalisee dans la base de donnees par le nom
	 * @param name 
	 * @return liste des employés
	 */
	
	@Query("from Employe where Nom like %?1%")
	public List<Employe> findByName(String name);
	
	/**
	 * Recherche d'un employe par le matricule
	 * @param matricule
	 * @return employe
	 */
	
	@Query("from Employe where matricule = ?")
	public List<Employe> findByMat(String matricule);

}
=======
package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.simplon.domain.Employe;

/**
 * Interface du CRUD
 * 
 * @author JGL
 *
 */
@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {
	
	/**
	 * lecture personnalisee dans la base de donnees par le nom
	 * @param name 
	 * @return liste des employés
	 */
	
	@Query("from Employe where Nom like %?1%")
	public List<Employe> findByName(String name);
	
	/**
	 * Recherche d'un employe par le matricule
	 * @param matricule
	 * @return employe
	 */
	
	@Query("from Employe where matricule = ?")
	public List<Employe> findByMat(String matricule);

}
>>>>>>> master
