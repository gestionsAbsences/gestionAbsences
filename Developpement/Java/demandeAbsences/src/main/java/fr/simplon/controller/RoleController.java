package fr.simplon.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.common.ResponseError;
import fr.simplon.domain.Role;
import fr.simplon.services.RoleService;

/**
 * Controleur REST de la classe Role
 * @author simplon
 *
 */
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	/**
	 * Liste des roles
	 * @param search : critère de recherche
	 * @param searchnew : 2eme critere de recherche 
	 * @return liste des roles
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listRoles(@RequestParam(value="searchnew", defaultValue="") String searchnew) {
		Iterable<Role> listRole = null;
		try {
			listRole = roleService.listRoles(searchnew);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listRole);
	}

	/**
	 * recherche d'un role. note : l'id est dans l'url et non en parametre
	 * 
	 * @param id : id du role
	 * @return : objet role
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRole(@PathVariable("id") Long id) {
		Role role = null;
		try {
			role = roleService.getRole(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		if (role == null) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_NOT_FOUND, "Aucun enregistrement");
		}
		return ResponseEntity.status(HttpStatus.OK).body(role);
	}

	/**
	 * creation d'un role
	 * 
	 * @param role : role
	 * @param errors : erreur de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<?> save(@Valid ServiceRh serviceRh, BindingResult result) {}
//	public ResponseEntity<?> insertRole(@Valid @RequestBody Role role , Errors errors) {
	public ResponseEntity<?> save(@Valid Role role, BindingResult errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return ResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			role = roleService.insertRole(role);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(role);
	}
	
	/**
	 * 
	 * @param role : role
	 * @param errors : erreurs de validation
	 * @return : réponse de la requête
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.PUT)
//	public ResponseEntity<?> update(@Valid ServiceRh serviceRh, BindingResult result) {			
//	public ResponseEntity<?> updateRole(@Valid @RequestBody Role role, Errors errors) {
	public ResponseEntity<?> updateRole(@Valid Role role, BindingResult result) throws Exception {
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
				role =  roleService.updateRole(role);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(role.getRole()+" modifié.");


//		if (errors.hasErrors()) {
//			return ResponseError.extractErrorWhenIncompletRequest(errors);
//		}
//
//		try {
//			roleService.updateRole(role);
//		} catch (Exception e) {
//			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(role);
	}

	/**
	 * suppression d'un role
	 * 
	 * @param id : id du role
	 * @return : réponse de la requête sans contenu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("id") Long id) {

		try {
			roleService.deleteRole(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	
}
