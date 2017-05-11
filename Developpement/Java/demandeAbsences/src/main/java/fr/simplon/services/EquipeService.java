package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.simplon.dao.EquipeDao;
import fr.simplon.domain.Employe;
import fr.simplon.domain.Equipe;

/**
 * Classe métier du service EQUIPE
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
				eq.setId_hierarchie(equipe.getId_hierarchie());
				eq.setId_responsable(equipe.getId_responsable());
				eq.setNom(equipe.getNom());
				
				Equipe pr = new Equipe();
				pr.setId(equipe.getParent().getId());
				pr.setId_hierarchie(equipe.getParent().getId_hierarchie());
				pr.setId_responsable(equipe.getParent().getId_responsable());
				pr.setNom(equipe.getParent().getNom());
				eq.setParent(pr);

				eq.setEmployes(new ArrayList<>());
				for (Employe emp : eq.getEmployes()) {
					Employe em = new Employe();
					em.setId(emp.getId());
					em.setNom(emp.getNom());
					em.setPrenom(emp.getPrenom());
					em.setMatricule(emp.getMatricule());
					eq.getEmployes().add(em);
				}

				Employe rp = new Employe();
				rp.setNom(equipe.getResponsables().getNom());
				rp.setPrenom(equipe.getResponsables().getPrenom());
				rp.setMatricule(equipe.getResponsables().getMatricule());
				eq.setResponsables(rp);


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
				eq.setId_hierarchie(equipe.getId_hierarchie());
				eq.setId_responsable(equipe.getId_responsable());
				eq.setNom(equipe.getNom());
				
				Equipe pr = new Equipe();
				pr.setId(equipe.getParent().getId());
				pr.setId_hierarchie(equipe.getParent().getId_hierarchie());
				pr.setId_responsable(equipe.getParent().getId_responsable());
				pr.setNom(equipe.getParent().getNom());
				eq.setParent(pr);

				eq.setEmployes(new ArrayList<>());
				for (Employe emp : eq.getEmployes()) {
					Employe em = new Employe();
					em.setId(emp.getId());
					em.setNom(emp.getNom());
					em.setPrenom(emp.getPrenom());
					em.setMatricule(emp.getMatricule());
					eq.getEmployes().add(em);
				}

				Employe rp = new Employe();
				rp.setNom(equipe.getResponsables().getNom());
				rp.setPrenom(equipe.getResponsables().getPrenom());
				rp.setMatricule(equipe.getResponsables().getMatricule());
				eq.setResponsables(rp);


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
	public void deleteEquipe(Equipe sup_equipe) throws SQLException {
		try{
			Iterable<Equipe> temp = dao.findByName(sup_equipe.getNom());
			for (Equipe equipe : temp) {
				Equipe eq = new Equipe();
				eq.setId(equipe.getId());
				eq.setId_hierarchie(equipe.getId_hierarchie());
				eq.setId_responsable(equipe.getId_responsable());
				eq.setNom(equipe.getNom());
				dao.delete(eq);
			}
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteEquipe" + e);
			throw e;
		}
	}

}
