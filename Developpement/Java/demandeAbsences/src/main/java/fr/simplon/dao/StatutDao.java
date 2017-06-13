package fr.simplon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.simplon.domain.Statut;

public interface StatutDao extends JpaRepository<Statut, Long>{
	
	 
	@Query("from Statut where code = ? ")
	public Statut findByCode(int code);

}


