package fr.simplon.services;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.controller.Type;

/**
 * service gérant l'acteur
 * C'est la couche métier.
 * 
 * @author simplon
 *
 */
@Service
public class TypeService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TypeRepository repo;

	public Iterable<Type> listTypes(String search, String searchNew) throws Exception {
		try {
			if (! "".equals(searchNew))
				return repo.findNewTypes(searchNew);
			else if (! "".equals(search))
				return repo.findByFirstNameContainingOrLastNameContaining(search, search);
			else
				return repo.findAll();
		} catch (Exception e) {
			log.error("Hibrnate Error !: listTypes", e);
			throw e;
		}
	}

	public Type getType(Long id) throws Exception {
		Type type = null;
		try {
			type = repo.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getType", e);
			throw e;
		}
		return type;
	}

	public Type insertType(Type type) throws Exception {
		try {
			type.setId(new Long(0));
			type.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			type = repo.save(type);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertType", e);
			throw e;
		}
		return type;
	}

	public void updateType(Type type) throws Exception {
		try {
			type.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			repo.save(type);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateType", e);
			throw e;
		}
	}

	public void deleteType(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteType", e);
			throw e;
		}
	}

}
