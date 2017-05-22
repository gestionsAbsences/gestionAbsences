package fr.simplon.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.domain.Absence;
import fr.simplon.services.AbsenceService;

/**
 * CRUD des services ABSENCE
 * 
 * @author JGL
 * 
 */

/*
 * Controlleur pour la gestion des services Absence
 * J'ai utilisé le verbe correspondant à l'action 
 * (get : lecture, post : création, put : mise à jour et delete: supression
 * url àsaisir dans le navigateur : localhost:8080/absence/nomMethode
 */

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@RestController
@RequestMapping("absence")
public class AbsenceController {
	
	@Autowired
	AbsenceService absenceService;
	
	/**
	 * Liste des services absence
	 * 
	 * @return liste des services absence
	 */
	
	/*
	 * Affiche la liste des services absence
	 * ResponseEntity permet gérer la réponse envoyée au front
	 */
	@GetMapping("listeService")
	public ResponseEntity<?> findAll() {	
		List<Absence> absence = new ArrayList<Absence>();
		try {
		absence = (List<Absence>) absenceService.listeServicesAbsence();
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence);
	}
	
	/**
	 * 
	 * Recherche des services Absence par le nom
	 * 
	 * @param String nom
	 * 
	 * @return 1 ou  plusieurs entités absence 
	 * 
	 */
	
	/*
	 * Cette methode recherche un service Absencepar le nom
	 * Il suffit de rentrer une lettre et la liste des services
	 * contenant cette lettre sera affichée
	 */
	
	@GetMapping("getService")
	public ResponseEntity<?> findById(@RequestParam(value="id", defaultValue="") Long id) {	
		List<Absence> absence = new ArrayList<Absence>();
		try {
			absence = (List<Absence>) absenceService.getAbsence(id);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence);
	}
	
	/**
	 * Création de nouveaux services Absence
	 * 
	 * @param email et nom du service Absence
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [Absence absence]
	 * et de capter le résultat  [BindingResult result]
	 */
	@PostMapping(value="/creerService", consumes = "application/json")	
	public ResponseEntity<?> save(@Valid Absence absence, BindingResult result) {			
	/*
	 * On capture les éventuelles erreurs dans une map 
	 * sous forme : key, value
	 * et formatée pour l'affichage
	 */
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			if(result.hasErrors()){
				for(FieldError error : result.getFieldErrors()){
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
		absence =  absenceService.insertAbsence(absence);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence.getId()+" créée.");
	}
	
	/**
	 * Mise à jour d'un service Absence
	 * 
	 * @param email et nom du service Absence
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	
	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value="/updateService")	
	public ResponseEntity<?> update(@Valid Absence absence, BindingResult result) {			
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(result.hasErrors()){
				for(FieldError error : result.getFieldErrors()){
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
		absence =  absenceService.updateAbsence(absence);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence.getId()+" modifié.");
	}
	
	/**
	 * Supression d'un service Absence
	 * @param nom
	 * @return message de suppression
	 */
	/*
	 * La suppression se fait par le nom
	 * Le reste de l'action est dans la classe Service
	 */
	@DeleteMapping("deleteService")
	public ResponseEntity<?> delete(Absence absence) {	
		try {
			absenceService.deleteAbsence(absence);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence.getId() + " supprimé.");
	}

}

	


