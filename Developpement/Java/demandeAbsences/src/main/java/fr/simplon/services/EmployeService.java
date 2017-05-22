package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.EmployeDao;
import fr.simplon.domain.Employe;
import fr.simplon.domain.Equipe;
import fr.simplon.domain.User;

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
				em.setNbCa(employe.getNbCa());
				em.setNbRtt(employe.getNbRtt());
				em.setNbRc(employe.getNbRc());
				em.setReliquatCa(employe.getReliquatCa());
				em.setReliquatRtt(employe.getReliquatRtt());
				em.setIdEquipe(employe.getIdEquipe());
				em.setIdServiceRh(employe.getIdServiceRh());
				
				em.setAbsences(employe.getAbsences());
				em.setGestionnaireRh(employe.getGestionnaireRh());
				
				Equipe eq = new Equipe();
				eq.setId(employe.getEquipes().getId());
				eq.setNom(employe.getEquipes().getNom());
				eq.setIdResponsable(employe.getEquipes().getIdResponsable());
				em.setEquipes(eq);
				
				User us = new User();
				us.setId(employe.getUsers().getId());
				us.setEmail(employe.getUsers().getEmail());
				us.setPassword(employe.getUsers().getPassword());
				em.setUsers(us);
				
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
				em.setPrenom(employe.getPrenom());
				em.setMatricule(employe.getMatricule());
				em.setNbCa(employe.getNbCa());
				em.setNbRtt(employe.getNbRtt());
				em.setNbRc(employe.getNbRc());
				em.setReliquatCa(employe.getReliquatCa());
				em.setReliquatRtt(employe.getReliquatRtt());
				em.setIdEquipe(employe.getIdEquipe());
				em.setIdServiceRh(employe.getIdServiceRh());
				
				em.setAbsences(employe.getAbsences());
				em.setGestionnaireRh(employe.getGestionnaireRh());
				
				Equipe eq = new Equipe();
				eq.setId(employe.getEquipes().getId());
				eq.setNom(employe.getEquipes().getNom());
				eq.setIdResponsable(employe.getEquipes().getIdResponsable());
				em.setEquipes(eq);
				
				User us = new User();
				us.setId(employe.getUsers().getId());
				us.setEmail(employe.getUsers().getEmail());
				us.setPassword(employe.getUsers().getPassword());
				em.setUsers(us);
				
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
	public void deleteEmploye(Employe supEmploye) throws SQLException {
		try{
			Iterable<Employe> temp = dao.findByName(supEmploye.getNom());
			for (Employe employe : temp) {
				Employe em = new Employe();
				em.setId(employe.getId());
				em.setNom(employe.getNom());
				em.setPrenom(employe.getPrenom());
				em.setMatricule(employe.getMatricule());
				em.setNbCa(employe.getNbCa());
				em.setNbRtt(employe.getNbRtt());
				em.setNbRc(employe.getNbRc());
				em.setReliquatCa(employe.getReliquatCa());
				em.setReliquatRtt(employe.getReliquatRtt());
				em.setIdEquipe(employe.getIdEquipe());
				em.setIdServiceRh(employe.getIdServiceRh());
				dao.delete(em);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteEmploye" + e);
			throw e;
		}
	}

}
