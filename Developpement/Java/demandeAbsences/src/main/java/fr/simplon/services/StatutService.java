package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.StatutDao;
import fr.simplon.domain.Statut;

/**
 * Classe métier du service STATUT
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class StatutService {

	@Autowired
	private StatutDao dao;
	
	/**
	 * Liste des services Statut
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<Statut> listeServicesStatut() throws SQLException {
		List<Statut> resultat = new ArrayList<>();
		try {
			Iterable<Statut> recherche = dao.findAll();
			for (Statut statut : recherche) {
				Statut st = new Statut();
				st.setId(statut.getId());
				st.setNom(statut.getNom());
				st.setAbsences(statut.getAbsences());
				resultat.add(st);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeStatut" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service Statut
	 * @param nom
	 * @return une liste des services statut en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<Statut> getStatut(String nom) throws SQLException {
		List<Statut> resultat = new ArrayList<>();
		try {
			Iterable<Statut> recherche = dao.findByName(nom);
			for (Statut statut : recherche) {
				Statut st = new Statut();
				st.setId(statut.getId());
				st.setNom(statut.getNom());
				st.setAbsences(statut.getAbsences());
				resultat.add(st);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeStatut" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Statut
	 * @param statut
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Statut
	 * J'ai crée un bojet Statut pour avoir le resultat de la creation en retour
	 */
	public Statut insertStatut(Statut statut) throws SQLException {
		Statut creation = new Statut();
		try {
			creation = dao.save(statut);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertStatut" + e);
			throw e;
		}
		return (Statut) creation;
	}

	/**
	 * Modification service Statut
	 * @param statut
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Statut updateStatut(Statut statut) throws SQLException {
		Statut modif = new Statut();
		try {
			modif = dao.save(statut);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateStatut" + e);
			throw e;
		}
		return (Statut) modif;
	}

	/**
	 * Suppression Service Statut
	 * @param statut
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service statut
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteStatut(Statut supStatut) throws SQLException {
		try{
			Iterable<Statut> temp = dao.findByName(supStatut.getNom());
			for (Statut statut : temp) {
				Statut st = new Statut();
				st.setId(statut.getId());
				st.setNom(statut.getNom());
				st.setAbsences(statut.getAbsences());
				dao.delete(st);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteStatut" + e);
			throw e;
		}
	}

}
