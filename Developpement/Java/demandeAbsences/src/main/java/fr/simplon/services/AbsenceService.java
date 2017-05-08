package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.AbsenceDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.ServiceRh;
import fr.simplon.domain.Statut;
import fr.simplon.domain.TypeAbsence;

/**
 * Classe métier du service Absence
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
<<<<<<< HEAD
				Absence ab = new Absence();
				ab.setId(absence.getId());
				ab.setDebut(absence.getDebut());
				ab.setFin(absence.getFin());
				ab.setId_employe(absence.getId_employe());
				ab.setId_type(absence.getId_type());
				ab.setId_statut(absence.getId_statut());
				ab.setId_service_rh(absence.getId_service_rh());

				TypeAbsence ta = new TypeAbsence();
				ta.setId(absence.getTypes().getId());
				ta.setNom(absence.getTypes().getNom());
				ab.setTypes(ta);

				Statut st = new Statut();
				st.setId(absence.getStatuts().getId());
				st.setNom(absence.getStatuts().getNom());
				ab.setStatuts(st);
				
				ServiceRh sr = new ServiceRh();
				sr.setId(absence.getRhs().getId());
				sr.setNom(absence.getRhs().getNom());
				sr.setEmail(absence.getRhs().getEmail());
				ab.setRhs(sr);

				resultat.add(ab);
=======
				Absence st = new Absence();
				st.setId(absence.getId());
				st.setDebut_abs(absence.getDebut_abs());
				st.setFin_abs(absence.getFin_abs());
				st.setId_employe(absence.getId_employe());
				st.setId_type(absence.getId_type());
				st.setId_statut(absence.getId_statut());
				st.setId_service_rh(absence.getId_service_rh());
				resultat.add(st);
>>>>>>> refs/remotes/origin/master
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

				TypeAbsence ta = new TypeAbsence();
<<<<<<< HEAD
=======
				st.setId(absence.getId());
				st.setDebut_abs(absence.getDebut_abs());
				st.setFin_abs(absence.getFin_abs());
				st.setId_employe(absence.getId_employe());
				st.setId_type(absence.getId_type());
				st.setId_statut(absence.getId_statut());
				st.setId_service_rh(absence.getId_service_rh());
>>>>>>> master
				ta.setId(absence.getTypes().getId());
				ta.setNom(absence.getTypes().getNom());
				ab.setTypes(ta);

				Statut st = new Statut();
				st.setId(absence.getStatuts().getId());
				st.setNom(absence.getStatuts().getNom());
				ab.setStatuts(st);
				
				ServiceRh sr = new ServiceRh();
				sr.setId(absence.getRhs().getId());
				sr.setNom(absence.getRhs().getNom());
				sr.setEmail(absence.getRhs().getEmail());
				ab.setRhs(sr);
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
	public void deleteAbsence(Absence absence) throws SQLException {
		try{
			Iterable<Absence> temp = dao.findById(absence.getId());
			Absence ab = new Absence();
			for (Absence service : temp) {
<<<<<<< HEAD
				ab.setId(service.getId());
				ab.setDebut(service.getDebut());
				ab.setFin(service.getFin());
				ab.setId_employe(service.getId_employe());
				ab.setId_type(service.getId_type());
				ab.setId_statut(service.getId_statut());
				ab.setId_service_rh(service.getId_service_rh());
				dao.delete(ab);
=======
				st.setId(service.getId());
				st.setDebut_abs(service.getDebut_abs());
				st.setFin_abs(service.getFin_abs());
				st.setId_employe(service.getId_employe());
				st.setId_type(service.getId_type());
				st.setId_statut(service.getId_statut());
				st.setId_service_rh(service.getId_service_rh());
				ta.setId(service.getTypes().getId());
				ta.setNom(service.getTypes().getNom());
				st.setTypes(ta);
				dao.delete(st);
>>>>>>> master
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteAbsence" + e);
			throw e;
		}
	}

}
