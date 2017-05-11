package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.AbsenceDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.Employe;
import fr.simplon.domain.ServiceRh;
import fr.simplon.domain.Statut;
import fr.simplon.domain.TypeAbsence;

/**
 * Classe métier du service ABSENCE
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class AbsenceService {

	@Autowired
	private AbsenceDao dao;
	
	/**
	 * Liste des services Absence
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<Absence> listeServicesAbsence() throws SQLException {
		List<Absence> resultat = new ArrayList<>();
		try {
			Iterable<Absence> recherche = dao.findAll();

			for (Absence absence : recherche) {
				Absence ab = new Absence();
				ab.setId(absence.getId());
				ab.setDebut(absence.getDebut());
				ab.setFin(absence.getFin());
				ab.setId_employe(absence.getId_employe());
				ab.setId_type(absence.getId_type());
				ab.setId_statut(absence.getId_statut());
				ab.setId_service_rh(absence.getId_service_rh());

				Employe em = new Employe();
				em.setId(absence.getEmployes().getId());
				em.setNom(absence.getEmployes().getNom());
				em.setPrenom(absence.getEmployes().getPrenom());
				em.setMatricule(absence.getEmployes().getMatricule());
				em.setNb_cp(absence.getEmployes().getNb_cp());
				em.setNb_rtt(absence.getEmployes().getNb_rtt());
				em.setNb_rc(absence.getEmployes().getNb_rc());
				em.setReliquat_ca(absence.getEmployes().getReliquat_ca());
				em.setReliquat_rtt(absence.getEmployes().getReliquat_rtt());
				em.setId_equipe(absence.getEmployes().getId_equipe());
				em.setId_service_rh(absence.getEmployes().getId_service_rh());
				ab.setEmployes(em);

				TypeAbsence ta = new TypeAbsence();
				ta.setId(absence.getTypes().getId());
				ta.setNom(absence.getTypes().getNom());
				ab.setTypes(ta);

				Statut st = new Statut();
				st.setId(absence.getStatuts().getId());
				st.setNom(absence.getStatuts().getNom());
				ab.setStatuts(st);
				
				ServiceRh sr = new ServiceRh();
				sr.setId(absence.getValideur_rh().getId());
				sr.setNom(absence.getValideur_rh().getNom());
				sr.setEmail(absence.getValideur_rh().getEmail());
				ab.setValideur_rh(sr);

				resultat.add(ab);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeAbsence" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service Absence
	 * @param nom
	 * @return une liste des services absence en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<Absence> getAbsence(Long id) throws SQLException {
		List<Absence> resultat = new ArrayList<>();
		try {
			Iterable<Absence> recherche = dao.findById(id);
			for (Absence absence : recherche) {
			Absence ab = new Absence();
			ab.setId(absence.getId());
			ab.setDebut(absence.getDebut());
			ab.setFin(absence.getFin());
			ab.setId_employe(absence.getId_employe());
			ab.setId_type(absence.getId_type());
			ab.setId_statut(absence.getId_statut());
			ab.setId_service_rh(absence.getId_service_rh());

			Employe em = new Employe();
			em.setId(absence.getEmployes().getId());
			em.setNom(absence.getEmployes().getNom());
			em.setPrenom(absence.getEmployes().getPrenom());
			em.setMatricule(absence.getEmployes().getMatricule());
			em.setNb_cp(absence.getEmployes().getNb_cp());
			em.setNb_rtt(absence.getEmployes().getNb_rtt());
			em.setNb_rc(absence.getEmployes().getNb_rc());
			em.setReliquat_ca(absence.getEmployes().getReliquat_ca());
			em.setReliquat_rtt(absence.getEmployes().getReliquat_rtt());
			em.setId_equipe(absence.getEmployes().getId_equipe());
			em.setId_service_rh(absence.getEmployes().getId_service_rh());
			ab.setEmployes(em);

			TypeAbsence ta = new TypeAbsence();
			ta.setId(absence.getTypes().getId());
			ta.setNom(absence.getTypes().getNom());
			ab.setTypes(ta);

			Statut st = new Statut();
			st.setId(absence.getStatuts().getId());
			st.setNom(absence.getStatuts().getNom());
			ab.setStatuts(st);
			
			ServiceRh sr = new ServiceRh();
			sr.setId(absence.getValideur_rh().getId());
			sr.setNom(absence.getValideur_rh().getNom());
			sr.setEmail(absence.getValideur_rh().getEmail());
			ab.setValideur_rh(sr);

			resultat.add(ab);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeAbsence" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Absence
	 * @param absence
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Absence
	 * J'ai crée un bojet Absence pour avoir le resultat de la creation en retour
	 */
	public Absence insertAbsence(Absence absence) throws SQLException {
		Absence creation = new Absence();
		try {
			creation = dao.save(absence);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertAbsence" + e);
			throw e;
		}
		return (Absence) creation;
	}

	/**
	 * Modification service Absence
	 * @param absence
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Absence updateAbsence(Absence absence) throws SQLException {
		Absence modif = new Absence();
		try {
			modif = dao.save(absence);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateAbsence" + e);
			throw e;
		}
		return (Absence) modif;
	}

	/**
	 * Suppression Service Absence
	 * @param absence
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service absence
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteAbsence(Absence sup_absence) throws SQLException {
		try{
			Iterable<Absence> temp = dao.findById(sup_absence.getId());
			for (Absence absence : temp) {
				Absence ab = new Absence();
				ab.setId(absence.getId());
				ab.setDebut(absence.getDebut());
				ab.setFin(absence.getFin());
				ab.setId_employe(absence.getId_employe());
				ab.setId_type(absence.getId_type());
				ab.setId_statut(absence.getId_statut());
				ab.setId_service_rh(absence.getId_service_rh());
				dao.delete(ab);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteAbsence" + e);
			throw e;
		}
	}

}
