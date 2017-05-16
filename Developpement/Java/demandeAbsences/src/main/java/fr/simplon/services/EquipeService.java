package fr.simplon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.EquipeDao;
import fr.simplon.domain.Equipe;

/**
 * service gérant le equipe C'est la couche métier.
 * 
 * @author simplon
 *
 */
@Service
public class EquipeService {

	@Autowired
	private EquipeDao equipeDao;

	public List<Equipe> listEquipes() throws SQLException {
		List<Equipe> resultat = new ArrayList<Equipe>();
		try {
			resultat = equipeDao.findAll();
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listEquipes" + e);
			throw e;
		}
		return resultat;
	}

	public List<Equipe> getEquipe(String nom) throws SQLException {
		List<Equipe> resultat = new ArrayList<Equipe>();
		try {
			resultat = equipeDao.findEquipe(nom);
		} catch (Exception e) {
			System.out.println("Hibrnate Error !: getEquipe" + e);
			throw e;
		}
		return resultat;
	}

	public Equipe insertEquipe(Equipe equipe) throws SQLException {
		Equipe creationEquipe = new Equipe();
		try {
			creationEquipe = equipeDao.save(equipe);
		} catch (Exception e) {
			System.out.println("Hibrnate Error !: insertEquipe" + e);
			throw e;
		}
		return creationEquipe;
	}

	public Equipe updateEquipe(Equipe equipe) throws SQLException {
		Equipe modifEquipe;
		try {
			modifEquipe = equipeDao.save(equipe);
		} catch (Exception e) {
			System.out.println("Hibrnate Error !: updateEquipe" + e);
			throw e;
		}
		return modifEquipe;
	}

	public void deleteEquipe(String nom) throws SQLException {
		try {
			List<Equipe> supprEquipe = equipeDao.findEquipe(nom);
			equipeDao.delete(supprEquipe);
		} catch (Exception e) {
			System.out.println("Hibrnate Error !: deleteEquipe" + e);
			throw e;
		}
	}

}
