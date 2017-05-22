package fr.simplon.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
 * CRUD des absences
 * 
 * @author JGL
 * 
 */

/*
 * Controlleur pour la gestion des services Absence J'ai utilisé le verbe
 * correspondant à l'action (get : lecture, post : création, put : mise à jour
 * et delete: supression url àsaisir dans le navigateur :
 * localhost:8080/absence/nomMethode
 */

@RestController
@RequestMapping("absence")
public class AbsenceController {

	@Autowired
	AbsenceService absenceService;

	/**
	 * Liste des absences
	 * 
	 * @return liste des absences
	 */

	/*
	 * Affiche la liste des services absence 
	 * ResponseEntity permet gérer la réponse envoyée au front
	 * 
	 */
	@GetMapping("/listeAbsence")
	public ResponseEntity<?> findAll() {
		List<Absence> absence;
		try {
			absence =absenceService.listeServicesAbsence();
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence);
	}

	/**
	 * 
	 * Recherche des absences par le nom
	 * 
	 * @param String
	 *            nom
	 * 
	 * @return 1 entité absence
	 * 
	 */

	/*
	 * Cette methode recherche une absence par l'id
	 * 
	 */

	@GetMapping("/getAbsenceById")
	public ResponseEntity<?> findById(@RequestParam(value = "id", defaultValue = "") Long id) {
		List<Absence> absence;
		try {
			absence =(List<Absence>) absenceService.getAbsenceById(id);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence);
	}

	/**
	 * Création d'une nouvelle absence
	 * 
	 * @param id,
	 *            date debut, datefin, idEmploye, Type de congé, Statut du
	 *            congé, ServiceRh, types, statuts, valideurRh, employes;
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [Absence
	 * absence] et de capter le résultat [BindingResult result]
	 */
	@PostMapping(value = "/creerAbsence")
	public ResponseEntity<?> save(@Valid Absence absence, BindingResult result) {
		/*
		 * On capture les éventuelles erreurs dans une map sous forme : key,
		 * value et formatée pour l'affichage
		 */
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if (result.hasErrors()) {
				for (FieldError error : result.getFieldErrors()) {
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
				absence = absenceService.insertAbsence(absence);
			}
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence.getId() + " créée.");
	}

	/**
	 * Mise à jour d'une Absence
	 * 
	 * @param d°
	 *            que création
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */

	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value = "/updateAbsence")
	public ResponseEntity<?> update(@Valid Absence absence, BindingResult result) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (result.hasErrors()) {
				for (FieldError error : result.getFieldErrors()) {
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
				absence = absenceService.updateAbsence(absence);
			}
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence.getId() + " modifié.");
	}

	/**
	 * Supression d'une absence
	 * 
	 * @param id
	 * @return message de suppression
	 */
	/*
	 * La suppression se fait par l'id Le reste de l'action est dans la classe
	 * Service
	 */
	@DeleteMapping("/deleteAbsence")
	public ResponseEntity<?> delete(Absence absence) {
		try {
			absenceService.deleteAbsence(absence);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence.getId() + " supprimé.");
	}
}
