package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.EquipeDao;
import fr.simplon.domain.Equipe;

/**
 * Classe métier du service Equipe
 * 
 * @author JGL
 *
 */
@Service
@Transactional
public class EquipeService {

	@Autowired
	private EquipeDao dao;
	
	/**
	 * Liste des services Equipe
	 * @return une liste
	 * @throws SQLException
	 */
	/*
	 * La methode [findAll] retourne une iteration de la table
	 * Avec la boucle [for], on la parcours et on retourne une
	 * liste de la table
	 */
	public List<Equipe> listeServicesEquipe() throws SQLException {
		List<Equipe> resultat = new ArrayList<>();
		try {
			Iterable<Equipe> recherche = dao.findAll();

			for (Equipe equipe : recherche) {
				Equipe eq = new Equipe();
				eq.setId(equipe.getId());
				eq.setId_EquipeMere(equipe.getId_EquipeMere());
				eq.setId_Responsable(equipe.getId_Responsable());
				eq.setNom(equipe.getNom());
				resultat.add(eq);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeEquipe" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Recherche d'un service Equipe
	 * @param nom
	 * @return une liste des services equipe en fonction du nom
	 * @throws SQLException
	 */
	/*
	 * Meme principe que ci-dessus
	 * une iteration qu'on transforme en liste
	 */
	public List<Equipe> getEquipe(String nom) throws SQLException {
		List<Equipe> resultat = new ArrayList<>();
		try {
			Iterable<Equipe> recherche = dao.findByName(nom);
	
			for (Equipe equipe : recherche) {
				Equipe eq = new Equipe();
				eq.setId(equipe.getId());
				eq.setId_EquipeMere(equipe.getId_EquipeMere());
				eq.setId_Responsable(equipe.getId_Responsable());
				eq.setNom(equipe.getNom());
				resultat.add(eq);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listeEquipe" + e);
			throw e;
		}
		return resultat;
	}

	/**
	 * Creation nouveau service Equipe
	 * @param equipe
	 * @return objet
	 * @throws SQLException
	 */
	/*
	 * Simple methode hibernate pour la creation d'un nouveau service Equipe
	 * J'ai crée un bojet Equipe pour avoir le resultat de la creation en retour
	 */
	public Equipe insertEquipe(Equipe equipe) throws SQLException {
		Equipe creation = new Equipe();
		try {
			creation = dao.save(equipe);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertEquipe" + e);
			throw e;
		}
		return (Equipe) creation;
	}

	/**
	 * Modification service Equipe
	 * @param equipe
	 * @return Objet
	 * @throws SQLException
	 */
	/*
	 * Même principe que creation
	 */
	public Equipe updateEquipe(Equipe equipe) throws SQLException {
		Equipe modif = new Equipe();
		try {
			modif = dao.save(equipe);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateEquipe" + e);
			throw e;
		}
		return (Equipe) modif;
	}

	/**
	 * Suppression Service Equipe
	 * @param equipe
	 * @throws SQLException
	 */
	/*
	 * On commence par faire une recherche d'un service equipe
	 * avec la methode [findByName()]
	 * Et on supprime l'objet par la methode delete
	 * d'hibernate qui supprime une entité complete.
	 * Cette methode peut etre appelé à evoluer
	 */
	public void deleteEquipe(Equipe equipe) throws SQLException {
		try{
			Iterable<Equipe> temp = dao.findByName(equipe.getNom());
			Equipe eq = new Equipe();
			for (Equipe service : temp) {
				
				eq.setId(service.getId());
				eq.setId_EquipeMere(equipe.getId_EquipeMere());
				eq.setId_Responsable(equipe.getId_Responsable());
				eq.setNom(service.getNom());
			}
			dao.delete(eq);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteEquipe" + e);
			throw e;
		}
	}

}
