package fr.simplon.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.RoleDao;
import fr.simplon.domain.Role;

/**
 * service gérant le role
 * C'est la couche métier.
 * 
 * @author simplon
 *
 */
@Service
public class RoleService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RoleDao dao;

	public Iterable<Role> listRoles(String searchNew) throws Exception {
		try {
			if (! "".equals(searchNew))
				return dao.findNewRoles(searchNew);
			else
				return dao.findAll();
		} catch (Exception e) {
			log.error("Hibrnate Error !: listRoles", e);
			throw e;
		}
	}

	public Role getRole(Long id) throws Exception {
		Role role = null;
		try {
			role = dao.findOne(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: getRole", e);
			throw e;
		}
		return role;
	}

	public Role insertRole(Role role) throws Exception {
		try {
			role.setId(new Long(0));
			role = dao.save(role);
		} catch (Exception e) {
			log.error("Hibrnate Error !: insertRole", e);
			throw e;
		}
		return role;
	}

	public Role updateRole(Role role) throws Exception {
		try {
			dao.save(role);
		} catch (Exception e) {
			log.error("Hibrnate Error !: updateRole", e);
			throw e;
		}
		return role;
	}

	public void deleteRole(Long id) throws Exception {
		try {
			dao.delete(id);
		} catch (Exception e) {
			log.error("Hibrnate Error !: deleteRole", e);
			throw e;
		}
	}

}
