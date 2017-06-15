package fr.simplon.services.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.AbsenceDao;
import fr.simplon.dao.EmployeDao;
import fr.simplon.dao.StatutDao;
import fr.simplon.dao.TypeDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.Employe;
import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.exception.ServiceException;


/**
 * Classe de service pour la verification des droits à congés
 * 
 * le calcul des reliquats, et la sauvegarde des données
 * 
 * 
 * @author JGL
 *
 */

@Service
@Transactional
public class TraitementAbsence {

	@Autowired
	AbsenceDao absenceDao;

	@Autowired
	TypeDao typeDao;

	@Autowired
	StatutDao statutDao;

	@Autowired
	EmployeDao employeDao;

	public Absence demanderAbsence(AbsenceDto absenceDto) throws SQLException {
		Absence nouvelleAbs = new Absence();
		Employe employe = employeDao.findByMat("YLF246");
		int resultatAbs = 0;

		try {

			nouvelleAbs = creerAbsence(absenceDto, employe);
			resultatAbs = decompterJours(nouvelleAbs);
			//Vérification du nombre de jours d'absences pas supérieur au reliquat
//			if (resultatAbs < 0){
//				 throw new ServiceException("Vous avez pris trop de " + nouvelleAbs.getType().getNom() );
//			}
			// emailService.sendMailInJava(nouvelleAbs);
			nouvelleAbs.setStatut(statutDao.findByCode(1));
			System.out.println("resultatAbs" + resultatAbs);
			employe.setNbCa(resultatAbs);
//			absenceDao.save(nouvelleAbs);
//			employeDao.save(employe);

		} catch (Exception e) {
			throw new ServiceException("Hibernate Error !: insertAbsence" + e);
		}

		return nouvelleAbs;
	}
	
	//Création de l'objet Absence à partir du Dto

	private Absence creerAbsence(AbsenceDto absenceDto, Employe employe) {
		Absence creationAbs = new Absence();

		try {
			creationAbs.setDebut(absenceDto.getDebut());
			creationAbs.setFin(absenceDto.getFin());
			creationAbs.setNumDemande(absenceDto.getNumDemande());
			creationAbs.setCommentaire(absenceDto.getCommentaire());
			creationAbs.setType(typeDao.findTypeByName(absenceDto.getType()));
			creationAbs.setStatut(statutDao.findByName(absenceDto.getStatut()));
			creationAbs.setEmploye(employe);
		} catch (Exception e) {

		}
		return creationAbs;

	}

	//Décompte des jours d'absences
	
	private int decompterJours(Absence absence) throws ServiceException {
		DateTime dateDebut = new DateTime(absence.getDebut());
		DateTime dateFin = new DateTime(absence.getFin());
		Duration duree = new Duration(dateDebut, dateFin);
		int joursAbs = Math.toIntExact(duree.getStandardDays());
		int reliquat = 0;

		//Vérifie que l'employé ne prend pas plus de 4 semaines de congés
		if (joursAbs > 28) {
			throw new ServiceException("Vous ne pouvez pas prendre plus de 4 semaines de congés");
		}

		try {

			List<DateTime> ferie = new ArrayList<DateTime>(JourFerie.calculerFerie(dateDebut.getYear()));

			//Retire les jours fériés se situant pendant les congés
			if (absence.getStatut().getCode() == 0) {
				for (DateTime dateFerie : ferie) {
					if (dateDebut.isBefore(dateFerie) && dateFin.isAfter(dateFerie)) {
						joursAbs--;
					}
				}

			}

			reliquat = calculerReliquat(joursAbs, absence);

		} catch (Exception e) {

		}
		return reliquat;
	}

	//Méthode décomptant les jours d'absence en fonction du type de congés
	private int calculerReliquat(int joursAbs, Absence absence) throws RuntimeException{

		switch (absence.getType().getNom()) {
		case "Congé payé":
			if(joursAbs<absence.getEmploye().getNbCa()){
				int reliquat = absence.getEmploye().getNbCa() - joursAbs;
				System.out.println(reliquat + " " + joursAbs);
				return reliquat;
			}
		case "RTT":
			if(joursAbs>absence.getEmploye().getNbRtt()){
				int reliquat = absence.getEmploye().getNbRtt() - joursAbs;
				return reliquat;
			}
		case "Repos compensateur":
			if(joursAbs>absence.getEmploye().getNbRc()){
				int reliquat = absence.getEmploye().getNbRc() - joursAbs;
				return reliquat;
			}
		default:
			 throw new ServiceException("Vous avez pris trop de " + absence.getType().getNom() );
		}
	}
}
