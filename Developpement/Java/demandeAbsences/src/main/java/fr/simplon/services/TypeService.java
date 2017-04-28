package fr.simplon.services;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.TypeDao;
import fr.simplon.domain.TypeAbsence;

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

	public Iterable<TypeAbsence> listTypes(String searchNew) throws Exception {
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

	public TypeAbsence getType(Long id) throws Exception {
		TypeAbsence type = null;
		try {
			type = dao.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getType", e);
			throw e;
		}
		return type;
	}

	public TypeAbsence insertType(TypeAbsence type) throws Exception {
		try {
			type.setId(new Long(0));
			type = dao.save(type);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertType", e);
			throw e;
		}
		return type;
	}

	public void updateType(TypeAbsence type) throws Exception {
		try {
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
