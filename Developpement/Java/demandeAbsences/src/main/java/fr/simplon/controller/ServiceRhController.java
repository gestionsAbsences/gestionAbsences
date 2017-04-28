package fr.simplon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.common.ResponseError;
import fr.simplon.domain.ServiceRh;
import fr.simplon.services.ServiceRhService;

@RestController
@RequestMapping("/serviceRh")
public class ServiceRhController {
	
	@Autowired
	ServiceRhService serviceRhService;
	
	/**
	 * Liste des services rh
	 * @param search : critère de recherche
	 * @return liste des services rh
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listServicesRh(@RequestParam(value="search", defaultValue="") String search) {
		Iterable<ServiceRh> listServiceRh = null;
		try {
			listServiceRh = serviceRhService.listServicesRh(search);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listServiceRh);
	}
	
	/**
	 * recherche d'un service Rh. note : l'id est dans l'url et non en parametre
	 * 
	 * @param id : id du service
	 * @return : objet service Rh
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getServiceRH(@PathVariable("id") Long id) {
		ServiceRh serviceRh = null;
		try {
			serviceRh = serviceRhService.getServiceRh(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		if (serviceRh == null) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_NOT_FOUND, "Not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(serviceRh);
	}

	/**
	 * creation d'un service Rh
	 * 
	 * @param service Rh : service Rh
	 * @param errors : erreur de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> insertServiceRh(@Valid @RequestBody ServiceRh serviceRh , Errors errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return ResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			serviceRh = serviceRhService.insertServiceRh(serviceRh);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(serviceRh);
	}
	
	/**
	 * 
	 * @param Service Rh : service Rh
	 * @param errors : erreurs de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateServiceRh(@Valid @RequestBody ServiceRh serviceRh, Errors errors) {
		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return ResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			serviceRhService.updateServiceRh(serviceRh);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(serviceRh);
	}

	/**
	 * suppression d'un service Rh
	 * 
	 * @param id : id de l'acteur
	 * @return : réponse de la requête sans contenu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteServiceRh(@PathVariable("id") Long id) {

		try {
			serviceRhService.deleteServiceRh(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	

}
