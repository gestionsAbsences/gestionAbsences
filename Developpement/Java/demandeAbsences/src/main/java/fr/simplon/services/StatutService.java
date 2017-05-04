package fr.simplon.services;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.StatutDao;
import fr.simplon.domain.Statut;

@Service
public class StatutService {

		
	@Autowired
	private StatutDao statutDao;
	

	public Iterable<Statut> listStatuts(String search) throws Exception {
		try {
			if (! "".equals(search))
				return statutDao.findStatut(search);
			
			else
				return statutDao.findAll();
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listStatut"+ e);
			throw e;
		}
	}

	public Statut getStatut(Long id) throws Exception {
		Statut statut = null;
		try {
			statut = statutDao.findOne(id);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: getStatut"+ e);
			throw e;
		}
		return statut;
	}

	public Statut insertStatut(Statut statut) throws Exception {
		try {
			statut.setId(new Long(0));
			statut = statutDao.save(statut);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertStatut"+ e);
			throw e;
		}
		return statut;
	}

	public void updateStatut(Statut statut) throws Exception {
		try {
			statutDao.save(statut);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateStatut"+ e);
			throw e;
		}
	}

	public void deleteStatut(Long id) throws Exception {
		try {
			statutDao.delete(id);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteStatut"+ e);
			throw e;
		}
	}

}