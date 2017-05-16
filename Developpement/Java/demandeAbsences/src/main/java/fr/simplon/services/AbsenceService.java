package fr.simplon.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.AbsenceDao;
import fr.simplon.domain.Absence;

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

	/**
	 * Liste des absences
	 * 
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une liste de la table 
	 * La methode [findAll] est overrride.
	 */
	public List<Absence> listeServicesAbsence() throws SQLException {
		List<Absence> resultat;
		try {
			resultat = absenceDao.findAll();
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeAbsence" + e);
			throw e;
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
			System.out.println("Hibernate Error !: listeAbsence" + e);
			throw e;
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
	public Absence insertAbsence(Absence absence) throws SQLException {
		Absence creationAbs;
		try {
			creationAbs = absenceDao.save(absence);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertAbsence" + e);
			throw e;
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
			modifAbs = absenceDao.save(absence);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateAbsence" + e);
			throw e;
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
			System.out.println("Hibernate Error !: deleteAbsence" + e);
			throw e;
		}
	}
}
