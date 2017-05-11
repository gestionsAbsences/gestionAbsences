package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.ServiceRhDao;
import fr.simplon.domain.ServiceRh;

/**
 * Classe métier du service RH
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class ServiceRhService {

	@Autowired
	private ServiceRhDao rhDao;
	
	/**
	 * Liste des services Rh
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<ServiceRh> listeServicesRh() throws SQLException {
		List<ServiceRh> resultat = new ArrayList<>();
		try {
			Iterable<ServiceRh> recherche = rhDao.findAll();
			for (ServiceRh serviceRh : recherche) {
				ServiceRh rh = new ServiceRh();
				rh.setId(serviceRh.getId());
				rh.setEmail(serviceRh.getEmail());
				rh.setNom(serviceRh.getNom());
				resultat.add(rh);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeServiceRh" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service Rh
	 * @param nom
	 * @return une liste des services rh en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<ServiceRh> getServiceRh(String nom) throws SQLException {
		List<ServiceRh> resultat = new ArrayList<>();
		try {
			Iterable<ServiceRh> recherche = rhDao.findByName(nom);	
			for (ServiceRh serviceRh : recherche) {
				ServiceRh rh = new ServiceRh();
				rh.setId(serviceRh.getId());
				rh.setEmail(serviceRh.getEmail());
				rh.setNom(serviceRh.getNom());
				resultat.add(rh);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeServiceRh" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Rh
	 * @param serviceRh
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Rh
	 * J'ai crée un bojet ServiceRh pour avoir le resultat de la creation en retour
	 */
	public ServiceRh insertServiceRh(ServiceRh serviceRh) throws SQLException {
		ServiceRh creation = new ServiceRh();
		try {
			creation = rhDao.save(serviceRh);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertServiceRh" + e);
			throw e;
		}
		return (ServiceRh) creation;
	}

	/**
	 * Modification service Rh
	 * @param serviceRh
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public ServiceRh updateServiceRh(ServiceRh serviceRh) throws SQLException {
		ServiceRh modif = new ServiceRh();
		try {
			modif = rhDao.save(serviceRh);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateServiceRh" + e);
			throw e;
		}
		return (ServiceRh) modif;
	}

	/**
	 * Suppression Service Rh
	 * @param serviceRh
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service rh
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteServiceRh(ServiceRh sup_serviceRh) throws SQLException {
		try{
			Iterable<ServiceRh> temp = rhDao.findByName(sup_serviceRh.getNom());
			for (ServiceRh serviceRh : temp) {
				ServiceRh rh = new ServiceRh();
				rh.setId(serviceRh.getId());
				rh.setEmail(serviceRh.getEmail());
				rh.setNom(serviceRh.getNom());
				rhDao.delete(rh);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteServiceRh" + e);
			throw e;
		}
	}

}
