package fr.simplon.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.common.EmailException;
import fr.simplon.common.ServiceException;
import fr.simplon.dao.AbsenceDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.services.utils.TraitementAbsence;

/**
 * Classe metier des absences
 * 
 * @author JGL
 *
 */

@Service
@Transactional
public class AbsenceService {

	@Autowired
	private AbsenceDao absenceDao;
	
	@Autowired
	private TraitementAbsence traitementAbsence;
	

	/**
	 * Liste des absences
	 * 
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une liste de la table 
	 * La methode [findAll] est overide.
	 */
	public List<Absence> listeServicesAbsence() throws SQLException {
		List<Absence> resultat;
		try {
			resultat = absenceDao.findAll();
		} catch (Exception e) {
			throw new SQLException("Hibernate Error !: listeAbsence" + e);
		}
		return resultat;
	}

	/**
	 * Recherche d'une Absence
	 * 
	 * @param nom
	 * @return une liste des services absence en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus une iteration qu'on transforme en liste
	 */
	public List<Absence> getAbsenceById(Long id) throws SQLException {
		List<Absence> resultat;
		try {
			resultat = absenceDao.findById(id);
		} catch (Exception e) {
			throw new SQLException("Hibernate Error !: getAbsenceById" + e);
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Absence
	 * 
	 * @param absence
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Absence
	 * J'ai crée un bojet Absence pour avoir le resultat de la creation en
	 * retour
	 */
	public AbsenceDto insertAbsence(AbsenceDto absenceDto) throws SQLException {
		AbsenceDto creationAbs;
		try {
			if(absenceDto.getDebut().compareTo(absenceDto.getFin())>0){
				throw new ServiceException("La date de fin de congé doit être supèrieur à la date de début");
			} else {
				creationAbs = traitementAbsence.demanderAbsence(absenceDto);
			}
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: insertAbsence" + e);
		}
		return creationAbs;
	}

	/**
	 * Modification service Absence
	 * 
	 * @param absence
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Absence updateAbsence(Absence absence) throws SQLException {
		Absence modifAbs;
		try {
			if(absence.getDebut().compareTo(absence.getFin())>0){
				throw new Exception("La date de fin de congé doit être supèrieur à la date de début");
			} else {
				modifAbs = absenceDao.save(absence);
			}
		} catch (Exception e) {
			throw new SQLException("Hibernate Error !: insertAbsence" + e);
		}
		return modifAbs;
	}

	/**
	 * Suppression Service Absence
	 * 
	 * @param absence
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service absence avec la methode
	 * [findByName()] Et on supprime l'objet par la methode delete d'hibernate
	 * qui supprime une entité complete. Cette methode peut etre appelé à
	 * evoluer
	 */
	public void deleteAbsence(Absence absence) throws SQLException {
		try {
			absenceDao.delete(absence);
		} catch (Exception e) {
			throw new SQLException("Hibernate Error !: deleteAbsence" + e);
		}
	}
}
