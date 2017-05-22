package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.RoleDao;
import fr.simplon.domain.Role;

/**
 * Classe métier du service ROLE
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleDao dao;
	
	/**
	 * Liste des services Role
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<Role> listeServicesRole() throws SQLException {
		List<Role> resultat = new ArrayList<>();
		try {
			Iterable<Role> recherche = dao.findAll();
			for (Role role : recherche) {
				Role rl = new Role();
				rl.setId(role.getId());
				rl.setValeur(role.getValeur());
				rl.setUsers(role.getUsers());
				resultat.add(rl);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeRole" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service Role
	 * @param nom
	 * @return une liste des services role en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<Role> getRole(String nom) throws SQLException {
		List<Role> resultat = new ArrayList<>();
		try {
			Iterable<Role> recherche = dao.findByName(nom);
			for (Role role : recherche) {
				Role rl = new Role();
				rl.setId(role.getId());
				rl.setValeur(role.getValeur());
				rl.setUsers(role.getUsers());
				resultat.add(rl);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeRole" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Role
	 * @param role
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Role
	 * J'ai crée un bojet Role pour avoir le resultat de la creation en retour
	 */
	public Role insertRole(Role element) throws SQLException {
		Role creation = new Role();
		try {
			creation = dao.save(element);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertRole" + e);
			throw e;
		}
		return (Role) creation;
	}

	/**
	 * Modification service Role
	 * @param role
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Role updateRole(Role element) throws SQLException {
		Role modif = new Role();
		try {
			modif = dao.save(element);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateRole" + e);
			throw e;
		}
		return (Role) modif;
	}

	/**
	 * Suppression Service Role
	 * @param role
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service role
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteRole(Role supRole) throws SQLException {
		try{
			Iterable<Role> temp = dao.findByName(supRole.getValeur());
			for (Role role : temp) {
				Role rl = new Role();
				rl.setId(role.getId());
				rl.setValeur(role.getValeur());
				rl.setUsers(role.getUsers());
				dao.delete(rl);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteRole" + e);
			throw e;
		}
	}

}
