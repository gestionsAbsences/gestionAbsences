package fr.simplon.services;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.AbsenceDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.exception.ServiceException;
import fr.simplon.services.utils.MapperDto;
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

	//Il s'agit de l'injection de dépendance de Spring
	@Autowired
	private AbsenceDao absenceDao;
	
	@Autowired
	MapperDto convert;
	
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
	public List<AbsenceDto> listeServicesAbsence() throws SQLException {
		List<AbsenceDto> resultat;
		List<Absence> absence;
		try {
			//recherche la liste complète des absences
			absence = absenceDao.findAll();
			//converti le resultat en dto
			resultat = convert.convertListeAbsenceToDto(absence);
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
	public List<AbsenceDto> getAbsenceById(Long id) throws SQLException {
		List<AbsenceDto> resultat;
		List<Absence> absence;
		try {
			absence = absenceDao.findById(id);
			resultat=convert.convertListeAbsenceToDto(absence);
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
	 * Appelle une classe spécifique afin de verifier la validité des congés
	 */
	public AbsenceDto insertAbsence(AbsenceDto absenceDto) throws SQLException {
		
		//créer un objet absence Dto
		AbsenceDto resultatAbs;
		try {
			//vérifie que la date de fin de congé ne soit pas inférieur à la date de début
			if(absenceDto.getDebut().compareTo(absenceDto.getFin())>0){
				throw new ServiceException("La date de fin de congé doit être supèrieur à la date de début");
			} else {
				//envoie la demande vers le traitement
				//implemente le numéro de demande par un timeStamp
				String calendar = Calendar.getInstance().getTimeInMillis()+"";
				absenceDto.setNumDemande(calendar.substring(6,12));
				resultatAbs = traitementAbsence.demanderAbsence(absenceDto);
				
			}
		} catch (Exception e) {
			throw new ServiceException("Hibernate Error !: insertAbsence" + e);
		}
		return resultatAbs;
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
	public void deleteAbsence(AbsenceDto absenceDto) throws SQLException {
		try {
			Date now = new Date();
			if(now.compareTo(absenceDto.getDebut())>0){
				throw new ServiceException("Annulation impossible!");
			} else {
			Absence absence = convert.convertDtoToAbs(absenceDto);
			absenceDao.delete(absence);
			}
		} catch (Exception e) {
			throw new SQLException("Hibernate Error !: deleteAbsence" + e);
		}
	}
}
