package fr.simplon.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.AbsenceDao;
import fr.simplon.domain.Absence;

@Service
public class AbsenceService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AbsenceDao dao;
	public Iterable<Absence> listeAbsences(String searchNew) throws Exception {
		try {
			if (! "".equals(searchNew))
				return dao.findNewAbsences(searchNew);
			else
				return dao.findAll();
		} catch (Exception e) {
			log.error("Hibrnate Error !: listeAbsences", e);
			throw e;
		}
	}

	public Absence getAbsence(Long id) throws Exception {
		Absence absence = null;
		try {
			absence = dao.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getAbsence", e);
			throw e;
		}
		return absence;
	}

	public Absence insertAbsence(Absence absence) throws Exception {
		try {
			absence.setId(new Long(0));
			absence = dao.save(absence);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertAbsence", e);
			throw e;
		}
		return absence;
	}

	public Absence updateAbsence(Absence absence) throws Exception {
		try {
			dao.save(absence);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateAbsence", e);
			throw e;
		}
		return absence;
	}

	public void deleteAbsence(Long id) throws Exception {
		try {
			dao.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteAbsence", e);
			throw e;
		}

	}
}
