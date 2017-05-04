package fr.simplon.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.simplon.domain.Absence;

public interface AbsenceDao extends CrudRepository<Absence, Long> {

	@Query("from Absence where absence like %?1%")
	public Iterable<Absence> findNewAbsences(String nom);

}
