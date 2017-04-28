package fr.simplon.services;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.TypeDao;
import fr.simplon.domain.Type;

/**
 * service gérant le type
 * C'est la couche métier.
 * 
 * @author simplon
 *
 */
@Service
public class TypeService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TypeDao dao;

	public Iterable<Type> listTypes(String search, String searchNew) throws Exception {
		try {
			if (! "".equals(searchNew))
				return dao.findNewTypes(searchNew);
			else
				return dao.findAll();
		} catch (Exception e) {
			log.error("Hibrnate Error !: listTypes", e);
			throw e;
		}
	}

	public Type getType(Long id) throws Exception {
		Type type = null;
		try {
			type = dao.findOne(id);
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
			type = dao.save(type);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertType", e);
			throw e;
		}
		return type;
	}

	public void updateType(Type type) throws Exception {
		try {
			type.setLastUpdate(new Timestamp(System.currentTimeMillis()));
			dao.save(type);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateType", e);
			throw e;
		}
	}

	public void deleteType(Long id) throws Exception {
		try {
			dao.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteType", e);
			throw e;
		}
	}

}
