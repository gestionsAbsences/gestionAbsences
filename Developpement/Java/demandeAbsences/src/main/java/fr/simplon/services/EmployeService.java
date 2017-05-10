package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.EmployeDao;
import fr.simplon.domain.Employe;

/**
 * Classe métier du service EMPLOYE
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class EmployeService {

	@Autowired
	private EmployeDao dao;
	
	/**
	 * Liste des services Employe
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<Employe> listeServicesEmploye() throws SQLException {
		List<Employe> resultat = new ArrayList<>();
		try {
			Iterable<Employe> recherche = dao.findAll();
			for (Employe employe : recherche) {
				Employe em = new Employe();
				em.setId(employe.getId());
				em.setNom(employe.getNom());
				em.setPrenom(employe.getPrenom());
				em.setMatricule(employe.getMatricule());
				em.setNb_cp(employe.getNb_cp());
				em.setNb_rtt(employe.getNb_rtt());
				em.setNb_rc(employe.getNb_rc());
				em.setReliquat_ca(employe.getReliquat_ca());
				em.setReliquat_rtt(employe.getReliquat_rtt());
				em.setId_equipe(employe.getId_equipe());
				em.setId_service_rh(employe.getId_service_rh());
				em.setAbsences(employe.getAbsences());
				em.setEmprhs(employe.getEmprhs());

//				Equipe eq = employe.getEquipes();
//				eq.setId_hierarchie(0);
//				eq.setEmployes(null);
//				em.setEquipes(eq);
				
//				employe.getEquipes().setId_hierarchie(0);
//				em.setEquipes(employe.getEquipes());
				
				resultat.add(em);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeEmploye" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service Employe
	 * @param nom
	 * @return une liste des services employe en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<Employe> getEmploye(String nom) throws SQLException {
		List<Employe> resultat = new ArrayList<>();
		try {
			Iterable<Employe> recherche = dao.findByName(nom);
			for (Employe employe : recherche) {
				Employe em = new Employe();
				em.setId(employe.getId());
				em.setNom(employe.getNom());
				em.setMatricule(employe.getMatricule());
				em.setNb_cp(employe.getNb_cp());
				em.setNb_rtt(employe.getNb_rtt());
				em.setNb_rc(employe.getNb_rc());
				em.setReliquat_ca(employe.getReliquat_ca());
				em.setReliquat_rtt(employe.getReliquat_rtt());
				em.setId_equipe(employe.getId_equipe());
				em.setId_service_rh(employe.getId_service_rh());
				em.setAbsences(employe.getAbsences());
				resultat.add(em);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeEmploye" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Employe
	 * @param employe
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Employe
	 * J'ai crée un bojet Employe pour avoir le resultat de la creation en retour
	 */
	public Employe insertEmploye(Employe employe) throws SQLException {
		Employe creation = new Employe();
		try {
			creation = dao.save(employe);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertEmploye" + e);
			throw e;
		}
		return (Employe) creation;
	}

	/**
	 * Modification service Employe
	 * @param employe
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Employe updateEmploye(Employe employe) throws SQLException {
		Employe modif = new Employe();
		try {
			modif = dao.save(employe);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateEmploye" + e);
			throw e;
		}
		return (Employe) modif;
	}

	/**
	 * Suppression Service Employe
	 * @param employe
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service employe
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteEmploye(Employe employe) throws SQLException {
		try{
			Iterable<Employe> temp = dao.findByName(employe.getNom());
			for (Employe service : temp) {
				Employe em = new Employe();
				em.setId(service.getId());
				em.setNom(service.getNom());
				em.setMatricule(service.getMatricule());
				em.setNb_cp(service.getNb_cp());
				em.setNb_rtt(service.getNb_rtt());
				em.setNb_rc(service.getNb_rc());
				em.setReliquat_ca(service.getReliquat_ca());
				em.setReliquat_rtt(service.getReliquat_rtt());
				em.setId_equipe(service.getId_equipe());
				em.setId_service_rh(service.getId_service_rh());
				dao.delete(em);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteEmploye" + e);
			throw e;
		}
	}

}
