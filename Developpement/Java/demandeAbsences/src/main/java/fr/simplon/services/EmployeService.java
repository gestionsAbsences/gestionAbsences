<<<<<<< HEAD
package fr.simplon.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.common.EmailException;
import fr.simplon.common.ServiceException;
import fr.simplon.dao.EmployeDao;
import fr.simplon.domain.Employe;


/**
 * Classe metier de la gestion des employés
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class EmployeService {
	
	@Autowired
	EmployeDao employeDao;
	
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
	public List<Employe> listeEmployes() throws SQLException {
		List<Employe> listeEmployes;
		try {
			listeEmployes = employeDao.findAll();
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: listeEmployes" + e);
		}
		return listeEmployes;
	}

	/**
	 * Recherche d'un employe
	 * @param nom
	 * @return une liste des employes en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<Employe> getEmploye(String nom) throws SQLException {
		List<Employe> getEmploye;
		try {
			getEmploye = employeDao.findByName(nom);
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: getEmploye" + e);
		}
		return getEmploye;
	}

	/**
	 * Creation nouvel employe
	 * @param employe
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Rh
	 * J'ai crée un objet Employe pour avoir le resultat de la creation en retour
	 */
	public Employe insertEmploye(Employe employe) throws SQLException {
		Employe creationEmploye=null;
		try {
			if(!employeDao.findByMat(employe.getMatricule()).isEmpty()){
				throw new ServiceException("matricule déjà utilisé");
			} else {
				creationEmploye = employeDao.save(employe);
			}
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: insertEmploye" + e);
		}
		return creationEmploye;
	}

	/**
	 * Modification employe
	 * @param employe
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Employe updateEmploye(Employe employe) throws SQLException {
		Employe modifEmploye;
		try {
			modifEmploye = employeDao.save(employe);
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: updateEmploye" + e);
		}
		return modifEmploye;
	}

	/**
	 * Suppression Employe
	 * @param employe
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un employe par son matricule
	 * avec la methode [findByMat()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteEmploye(Employe supprEmploye) throws SQLException {
		try{		
			employeDao.delete(supprEmploye);
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: deleteEmploye" + e);
		}
	}
}
=======
package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.common.EmailException;
import fr.simplon.common.ServiceException;
import fr.simplon.dao.EmployeDao;
import fr.simplon.domain.Employe;
import fr.simplon.domain.dto.EmployeDto;


/**
 * Classe metier de la gestion des employés
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class EmployeService {
	
	@Autowired
	EmployeDao employeDao;
	
	@Autowired
	ConvertToDto convert;
	
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
	public List<EmployeDto> listeEmployes() throws SQLException {
		List<Employe> listeEmployes;
		List<EmployeDto> listeEmployesDto;
		try {
			listeEmployes = employeDao.findAll();
			listeEmployesDto=convert.convertListeEmployeToDto(listeEmployes);
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: listeEmployes" + e);
		}
		return listeEmployesDto;
	}

	/**
	 * Recherche d'un employe
	 * @param nom
	 * @return une liste des employes en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<EmployeDto> getEmploye(String nom) throws SQLException {
		List<Employe> getEmploye;
		List<EmployeDto> getEmployeDto;
		try {
			getEmploye = employeDao.findByName(nom);
			getEmployeDto=convert.convertListeEmployeToDto(getEmploye);
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: getEmploye" + e);
		}
		return getEmployeDto;
	}

	/**
	 * Creation nouvel employe
	 * @param employe
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Rh
	 * J'ai crée un objet Employe pour avoir le resultat de la creation en retour
	 */
	public Employe insertEmploye(Employe employe) throws SQLException {
		Employe creationEmploye=null;
		try {
			if(!employeDao.findByMat(employe.getMatricule()).isEmpty()){
				throw new ServiceException("matricule déjà utilisé");
			} else {
				creationEmploye = employeDao.save(employe);
			}
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: insertEmploye" + e);
		}
		return creationEmploye;
	}

	/**
	 * Modification employe
	 * @param employe
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Employe updateEmploye(Employe employe) throws SQLException {
		Employe modifEmploye;
		try {
			modifEmploye = employeDao.save(employe);
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: updateEmploye" + e);
		}
		return modifEmploye;
	}

	/**
	 * Suppression Employe
	 * @param employe
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un employe par son matricule
	 * avec la methode [findByMat()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteEmploye(Employe supprEmploye) throws SQLException {
		try{		
			employeDao.delete(supprEmploye);
		} catch (EmailException e) {
			throw new ServiceException("Hibernate Error !: deleteEmploye" + e);
		}
	}
}
>>>>>>> master
