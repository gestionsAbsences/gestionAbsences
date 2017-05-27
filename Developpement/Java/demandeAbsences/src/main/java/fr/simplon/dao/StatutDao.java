<<<<<<< HEAD
package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.simplon.domain.Statut;

public interface StatutDao extends JpaRepository<Statut, Long>{
	
	 
	@Query("from Statut where code = ? ")
	public List<Statut> findByCode(int code);

}


=======
package fr.simplon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.simplon.domain.Statut;

public interface StatutDao extends JpaRepository<Statut, Long>{
	
	 
	@Query("from Statut where code = ? ")
	public List<Statut> findByCode(int code);

}


>>>>>>> master
