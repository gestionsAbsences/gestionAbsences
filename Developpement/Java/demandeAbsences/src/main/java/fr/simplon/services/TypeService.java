package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.TypeDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.TypeAbsence;

/**
 * Classe métier du service TYPE
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class TypeService {

	@Autowired
	private TypeDao dao;
	
	/**
	 * Liste des services Type
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<TypeAbsence> listeServicesType() throws SQLException {
		List<TypeAbsence> resultat = new ArrayList<>();
		try {
			Iterable<TypeAbsence> recherche = dao.findAll();
			for (TypeAbsence type : recherche) {
				TypeAbsence tp = new TypeAbsence();
				tp.setId(type.getId());
				tp.setNom(type.getNom());
				tp.setAbsences(new ArrayList<>());
				for (Absence abs : tp.getAbsences()) {
					Absence ab = new Absence();
					ab.setId(abs.getId());
					ab.setDebut(abs.getDebut());
					ab.setFin(abs.getFin());
					ab.setIdEmploye(abs.getIdEmploye());
					ab.setIdType(abs.getIdType());
					ab.setIdStatut(abs.getIdStatut());
					ab.setIdServiceRh(abs.getIdServiceRh());
					tp.getAbsences().add(ab);
				}
				tp.setAbsences(type.getAbsences());
				resultat.add(tp);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeType" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service Type
	 * @param nom
	 * @return une liste des services type en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<TypeAbsence> getType(String nom) throws SQLException {
		List<TypeAbsence> resultat = new ArrayList<>();
		try {
			Iterable<TypeAbsence> recherche = dao.findByName(nom);
			for (TypeAbsence type : recherche) {
				TypeAbsence tp = new TypeAbsence();
				tp.setId(type.getId());
				tp.setNom(type.getNom());
				tp.setAbsences(new ArrayList<>());
				for (Absence abs : tp.getAbsences()) {
					Absence ab = new Absence();
					ab.setId(abs.getId());
					ab.setDebut(abs.getDebut());
					ab.setFin(abs.getFin());
					ab.setIdEmploye(abs.getIdEmploye());
					ab.setIdType(abs.getIdType());
					ab.setIdStatut(abs.getIdStatut());
					ab.setIdServiceRh(abs.getIdServiceRh());
					tp.getAbsences().add(ab);
				}
				tp.setAbsences(type.getAbsences());
				resultat.add(tp);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeType" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Type
	 * @param type
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Type
	 * J'ai crée un bojet Type pour avoir le resultat de la creation en retour
	 */
	public TypeAbsence insertType(TypeAbsence type) throws SQLException {
		TypeAbsence creation = new TypeAbsence();
		try {
			creation = dao.save(type);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertType" + e);
			throw e;
		}
		return (TypeAbsence) creation;
	}

	/**
	 * Modification service Type
	 * @param type
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public TypeAbsence updateType(TypeAbsence type) throws SQLException {
		TypeAbsence modif = new TypeAbsence();
		try {
			modif = dao.save(type);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateType" + e);
			throw e;
		}
		return (TypeAbsence) modif;
	}

	/**
	 * Suppression Service Type
	 * @param type
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service type
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteType(TypeAbsence supType) throws SQLException {
		try{
			Iterable<TypeAbsence> temp = dao.findByName(supType.getNom());
			TypeAbsence tp = new TypeAbsence();
			for (TypeAbsence type : temp) {
				tp.setId(type.getId());
				tp.setNom(type.getNom());
				dao.delete(tp);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteType" + e);
			throw e;
		}
	}

}
