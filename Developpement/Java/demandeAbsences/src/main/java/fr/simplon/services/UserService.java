package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.UserDao;
import fr.simplon.domain.Employe;
import fr.simplon.domain.User;

/**
 * Classe métier du service USER
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao dao;
	
	/**
	 * Liste des services User
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<User> listeServicesUser() throws SQLException {
		List<User> resultat = new ArrayList<>();
		try {
			Iterable<User> recherche = dao.findAll();
			for (User user : recherche) {
				User us = new User();
				us.setId(user.getId());
				us.setEmail(user.getEmail());
				us.setPassword(user.getPassword());
				us.setIdEmploye(user.getIdEmploye());
				us.setIdRole(user.getIdRole());
				us.setRoles(user.getRoles());
				
				Employe em = new Employe();
				em.setId(user.getUserEmploye().getId());
				em.setNom(user.getUserEmploye().getNom());
				em.setPrenom(user.getUserEmploye().getPrenom());
				em.setMatricule(user.getUserEmploye().getMatricule());
				us.setUserEmploye(em);

				resultat.add(us);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeUser" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service User
	 * @param nom
	 * @return une liste des services user en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<User> getUser(String nom) throws SQLException {
		List<User> resultat = new ArrayList<>();
		try {
			Iterable<User> recherche = dao.findByName(nom);
			for (User user : recherche) {
				User us = new User();
				us.setId(user.getId());
				us.setEmail(user.getEmail());
				us.setPassword(user.getPassword());
				us.setIdEmploye(user.getIdEmploye());
				us.setIdRole(user.getIdRole());
				us.setRoles(user.getRoles());
				
				Employe em = new Employe();
				em.setId(user.getUserEmploye().getId());
				em.setNom(user.getUserEmploye().getNom());
				em.setPrenom(user.getUserEmploye().getPrenom());
				em.setMatricule(user.getUserEmploye().getMatricule());
				us.setUserEmploye(em);

				resultat.add(us);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeUser" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service User
	 * @param user
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service User
	 * J'ai crée un bojet User pour avoir le resultat de la creation en retour
	 */
	public User insertUser(User user) throws SQLException {
		User creation = new User();
		try {
			creation = dao.save(user);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertUser" + e);
			throw e;
		}
		return (User) creation;
	}

	/**
	 * Modification service User
	 * @param user
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public User updateUser(User user) throws SQLException {
		User modif = new User();
		try {
			modif = dao.save(user);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateUser" + e);
			throw e;
		}
		return (User) modif;
	}

	/**
	 * Suppression Service User
	 * @param user
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service user
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteUser(User supUser) throws SQLException {
		try{
			Iterable<User> temp = dao.findByName(supUser.getEmail());
			for (User user : temp) {
				User us = new User();
				us.setId(user.getId());
				us.setEmail(user.getEmail());
				us.setPassword(user.getPassword());
				us.setIdEmploye(user.getIdEmploye());
				us.setIdRole(user.getIdRole());
				us.setRoles(user.getRoles());
				dao.delete(us);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteUser" + e);
			throw e;
		}
	}

}
