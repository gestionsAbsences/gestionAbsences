package fr.simplon.services;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.simplon.dao.ServiceRhDao;
import fr.simplon.domain.ServiceRh;

/**
 * Classe gérant le service RH
 * 
 * @author JGL
 *
 */
@Service
public class ServiceRhService {
	
	@Autowired
	private ServiceRhDao rhDao;

	public Iterable<ServiceRh> listServicesRh(String search) throws Exception {
		try {
			if (! "".equals(search))
				return rhDao.findServiceRh(search);
			
			else
				return rhDao.findAll();
		} catch (Exception e) {
			System.out.println("Hibernate Error !: listServiceRh"+ e);
			throw e;
		}
	}

	public ServiceRh getServiceRh(Long id) throws Exception {
		ServiceRh serviceRh = null;
		try {
			serviceRh = rhDao.findOne(id);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: getServiceRh"+ e);
			throw e;
		}
		return serviceRh;
	}

	public ServiceRh insertServiceRh(ServiceRh serviceRh) throws Exception {
		try {
			serviceRh.setId(new Long(0));
			serviceRh = rhDao.save(serviceRh);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: insertServiceRh"+ e);
			throw e;
		}
		return serviceRh;
	}

	public void updateServiceRh(ServiceRh serviceRh) throws Exception {
		try {
			rhDao.save(serviceRh);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: updateServiceRh"+ e);
			throw e;
		}
	}

	public void deleteServiceRh(Long id) throws Exception {
		try {
			rhDao.delete(id);
		} catch (Exception e) {
			System.out.println("Hibernate Error !: deleteServiceRh"+ e);
			throw e;
		}
	}

}
