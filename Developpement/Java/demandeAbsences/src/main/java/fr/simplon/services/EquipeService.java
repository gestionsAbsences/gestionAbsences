package fr.simplon.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.EquipeDao;
import fr.simplon.domain.Equipe;

/**
 * service gérant le equipe
 * C'est la couche métier.
 * 
 * @author simplon
 *
 */
@Service
public class EquipeService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EquipeDao dao;

	public Iterable<Equipe> listEquipes(String searchNew) throws Exception {
		try {
			if (! "".equals(searchNew))
				return dao.findNewEquipes(searchNew);
			else
				return dao.findAll();
		} catch (Exception e) {
			log.error("Hibrnate Error !: listEquipes", e);
			throw e;
		}
	}

	public Equipe getEquipe(Long id) throws Exception {
		Equipe equipe = null;
		try {
			equipe = dao.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getEquipe", e);
			throw e;
		}
		return equipe;
	}

	public Equipe insertEquipe(Equipe equipe) throws Exception {
		try {
			equipe.setId(new Long(0));
			equipe = dao.save(equipe);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertEquipe", e);
			throw e;
		}
		return equipe;
	}

	public Equipe updateEquipe(Equipe equipe) throws Exception {
		try {
			dao.save(equipe);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateEquipe", e);
			throw e;
		}
		return equipe;
	}

	public void deleteEquipe(Long id) throws Exception {
		try {
			dao.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteEquipe", e);
			throw e;
		}
	}

}
