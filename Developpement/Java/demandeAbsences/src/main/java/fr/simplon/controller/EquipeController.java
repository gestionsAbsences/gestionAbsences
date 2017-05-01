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
import fr.simplon.domain.Equipe;
import fr.simplon.services.EquipeService;

/**
 * Controleur REST de la classe Equipe
 * @author simplon
 *
 */
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/equipe")
public class EquipeController {

	@Autowired
	EquipeService equipeService;

	/**
	 * Liste des equipes
	 * @param search : critère de recherche
	 * @param searchnew : 2eme critere de recherche 
	 * @return liste des equipes
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listEquipes(@RequestParam(value="searchnew", defaultValue="") String searchnew) {
		Iterable<Equipe> listEquipe = null;
		try {
			listEquipe = equipeService.listEquipes(searchnew);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listEquipe);
	}

	/**
	 * recherche d'un equipe. note : l'id est dans l'url et non en parametre
	 * 
	 * @param id : id du equipe
	 * @return : objet equipe
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEquipe(@PathVariable("id") Long id) {
		Equipe equipe = null;
		try {
			equipe = equipeService.getEquipe(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		if (equipe == null) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_NOT_FOUND, "Aucun enregistrement");
		}
		return ResponseEntity.status(HttpStatus.OK).body(equipe);
	}

	/**
	 * creation d'un equipe
	 * 
	 * @param equipe : equipe
	 * @param errors : erreur de validation
	 * @return : réponse de la requête
	 */
	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity<?> save(@Valid ServiceRh serviceRh, BindingResult result) {}
//	public ResponseEntity<?> insertEquipe(@Valid @RequestBody Equipe equipe , Errors errors) {
	public ResponseEntity<?> save(@Valid Equipe equipe, BindingResult errors) {

		// Si erreur de validation, retour erreur 400 (bad request), avec le
		// message d'erreur
		if (errors.hasErrors()) {
			return ResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			equipe = equipeService.insertEquipe(equipe);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(equipe);
	}
	
	/**
	 * 
	 * @param equipe : equipe
	 * @param errors : erreurs de validation
	 * @return : réponse de la requête
	 * @throws Exception 
	 */
	@RequestMapping(method = RequestMethod.PUT)
//	public ResponseEntity<?> update(@Valid ServiceRh serviceRh, BindingResult result) {			
//	public ResponseEntity<?> updateEquipe(@Valid @RequestBody Equipe equipe, Errors errors) {
	public ResponseEntity<?> updateEquipe(@Valid Equipe equipe, BindingResult result) throws Exception {
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
				equipe =  equipeService.updateEquipe(equipe);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(equipe.getNom()+" modifié.");


//		if (errors.hasErrors()) {
//			return ResponseError.extractErrorWhenIncompletRequest(errors);
//		}
//
//		try {
//			equipeService.updateEquipe(equipe);
//		} catch (Exception e) {
//			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(equipe);
	}

	/**
	 * suppression d'un equipe
	 * 
	 * @param id : id du equipe
	 * @return : réponse de la requête sans contenu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEquipe(@PathVariable("id") Long id) {

		try {
			equipeService.deleteEquipe(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	
}
