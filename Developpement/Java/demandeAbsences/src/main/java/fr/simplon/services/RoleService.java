package fr.simplon.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.RoleDao;
import fr.simplon.domain.Role;

/**
 * service gérant le role C'est la couche métier.
 * 
 * @author simplon
 *
 */
@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public List<Role> listerRoles() throws SQLException {
		List<Role> resultat;
		try {
			resultat = roleDao.findAll();
		} catch (Exception e) {
			System.out.println("Hibrnate Error !: listRoles" + e);
			throw e;
		}
		return resultat;
	}

	public List<Role> getRoleByValue(int valeur) throws SQLException {
		List<Role> resultat;
		try {
			resultat = roleDao.findByValue(valeur);
		} catch (Exception e) {
			System.out.println("Hibrnate Error !: getRole" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau role
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
	public Role insertRole(Role role) throws SQLException {
		Role creationRole;
		try {
			creationRole = roleDao.save(role);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertRole" + e);
			throw e;
		}
		return creationRole;
	}

	/**
	 * Modification role
	 * 
	 * @param role
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Role updateRole(Role role) throws SQLException {
		Role modifRole;
		try {
			modifRole = roleDao.save(role);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateRole" + e);
			throw e;
		}
		return modifRole;
	}

	/**
	 * Suppression role
	 * 
	 * @param role
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service absence avec la methode
	 * [findByName()] Et on supprime l'objet par la methode delete d'hibernate
	 * qui supprime une entité complete. Cette methode peut etre appelé à
	 * evoluer
	 */
	public void deleteRole(Role role) throws SQLException {
		try {
			roleDao.delete(role);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteRole" + e);
			throw e;
		}
	}

}
