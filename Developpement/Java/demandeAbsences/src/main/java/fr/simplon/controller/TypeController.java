package fr.simplon.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.common.ResponseError;
import fr.simplon.domain.ServiceRh;
import fr.simplon.domain.TypeAbsence;
import fr.simplon.services.TypeService;

/**
 * Controleur REST de la classe Type
 * @author simplon
 *
 */
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/type")
public class TypeController {

	@Autowired
	TypeService typeService;

	/**
	 * Liste des types
	 * @param search : critère de recherche
	 * @param searchnew : 2eme critere de recherche 
	 * @return liste des types
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listTypes(@RequestParam(value="searchnew", defaultValue="") String searchnew) {
		Iterable<TypeAbsence> listType = null;
		try {
			listType = typeService.listTypes(searchnew);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listType);
	}

	/**
	 * recherche d'un type. note : l'id est dans l'url et non en parametre
	 * 
	 * @param id : id du type
	 * @return : objet type
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getType(@PathVariable("id") Long id) {
		TypeAbsence type = null;
		try {
			type = typeService.getType(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		if (type == null) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_NOT_FOUND, "Aucun enregistrement");
		}
		return ResponseEntity.status(HttpStatus.OK).body(type);
	}

	/**
	 * creation d'un type
	 * 
	 * @param type : type
	 * @param errors : erreur de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<?> save(@Valid ServiceRh serviceRh, BindingResult result) {}
//	public ResponseEntity<?> insertType(@Valid @RequestBody TypeAbsence type , Errors errors) {
	public ResponseEntity<?> save(@Valid TypeAbsence type, BindingResult errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return ResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			type = typeService.insertType(type);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(type);
	}
	
	/**
	 * 
	 * @param type : type
	 * @param errors : erreurs de validation
	 * @return : réponse de la requête
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.PUT)
//	public ResponseEntity<?> update(@Valid ServiceRh serviceRh, BindingResult result) {			
//	public ResponseEntity<?> updateType(@Valid @RequestBody TypeAbsence type, Errors errors) {
	public ResponseEntity<?> updateType(@Valid TypeAbsence type, BindingResult result) throws Exception {
		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur

		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(result.hasErrors()){
				for(FieldError error : result.getFieldErrors()){
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
				type =  typeService.updateType(type);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(type.getNom()+" modifié.");


//		if (errors.hasErrors()) {
//			return ResponseError.extractErrorWhenIncompletRequest(errors);
//		}
//
//		try {
//			typeService.updateType(type);
//		} catch (Exception e) {
//			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(type);
	}

	/**
	 * suppression d'un type
	 * 
	 * @param id : id du type
	 * @return : réponse de la requête sans contenu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteType(@PathVariable("id") Long id) {

		try {
			typeService.deleteType(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	
}
