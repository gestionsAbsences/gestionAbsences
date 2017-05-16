package fr.simplon.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.UserDao;
import fr.simplon.domain.User;

/**
 * Classe metier de la gestion des user
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;
	
	/**
	 * Liste des employes
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<User> listeUsers() throws SQLException {
		List<User> resultat;
		try {
			resultat = userDao.findAll();
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeEmployes" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un user
	 * @param email
	 * @return un profil employé
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<User> getUser(String email) throws SQLException {
		List<User> resultat;
		try {
			resultat = userDao.findByEmail(email);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: getUser" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau user
	 * @param user
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau user
	 * J'ai crée un objet User pour avoir le resultat de la creation en retour
	 */
	public User insertUser(User user) throws SQLException {
		User creationUser;
		try {
			creationUser = userDao.save(user);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertUser" + e);
			throw e;
		}
		return creationUser;
	}

	/**
	 * Modification user
	 * @param user
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public User updateUser(User user) throws SQLException {
		User modifUser;
		try {
			modifUser = userDao.save(user);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateUser" + e);
			throw e;
		}
		return modifUser;
	}

	/**
	 * Suppression User
	 * @param user
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un user par son adresse email
	 * avec la methode [findByEmail()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteUser(User supprUser) throws SQLException {
		try {
			userDao.delete(supprUser);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteUser" + e);
			throw e;
		}
	}
}
