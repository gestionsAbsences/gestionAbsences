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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.security.access.prepost.PreAuthorize;

import com.fasterxml.jackson.databind.node.ObjectNode;

import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.services.AbsenceService;

/**
 * CRUD des absences
 * 
 * @author JGL
 * 
 */

/*
 * Controleur pour la gestion des services Absence 
 * J'ai utilisé le verbe correspondant à l'action 
 * (get : lecture, post : création, put : mise à jour et delete: supression)
 *  url à saisir dans le navigateur : localhost:8080/absence/nomMethode
 */

@RestController // Indique qu'il s'agit d'un service REST
@RequestMapping("absence") // indique que toutes les uri contenant "absence" seront traitées ce controleur
@CrossOrigin(origins="*") // dire à java qu'il peut envoyer sur le port 3000
public class AbsenceController {

	@Autowired //Injection de la couche service pour le traitement des absences
	AbsenceService absenceService; // injecte la classe absence service dans la classe controlleurS

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

	@GetMapping("/listeAbsence") //raccourci pour la méthode : @RequestMapping(value = "/listeAbsence", method = RequestMethod.GET
	public ResponseEntity<?> findAll() { // retourne une réponse au front
		List<AbsenceDto> absence; // permet de transférer au front les éléments souhaités de la classe absences
		try {
			absence =absenceService.listeServicesAbsence();// essaye de retourner la liste des services  si erreur , il renvoi l'erreur
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence);
	}

	/**
	 * 
	 * Recherche des absences par le nom
	 * 
	 * @param String nom
	 * 
	 * @return 1 entité absence
	 * 
	 */

	/*
	 * Cette methode recherche une absence par l'id
	 * 
	 */

	@GetMapping("/getAbsenceById") // requête  get avec le paramètre obligatoire id
	public ResponseEntity<?> findById(@RequestParam(value = "id", defaultValue = "") Long id) {
		List<AbsenceDto> absence;
		try {
			absence =absenceService.getAbsenceById(id);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absence);
	}
	
	/**
	 * 
	 * Recherche des absences par le numero
	 * 
	 * @param String numero
	 * 
	 * @return 1 entité absence
	 * 
	 */

	/*
	 * Cette methode recherche une absence par l'id
	 * 
	 */


	@GetMapping("/getAbsenceByNum")
	public ResponseEntity<?> findById(@RequestParam(value = "numDemande", defaultValue = "") String numDemande) {
		AbsenceDto absenceDto;
		try {
			absenceDto =absenceService.getAbsenceByNumero(numDemande);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absenceDto);
	}

	/**
	 * Création d'une nouvelle absence
	 * 
	 * @param dateDebut, dateFin, typeCongé,
	 *            
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [AbsenceDto absenceDto] 
	 * et de capter le résultat [BindingResult result]
	 */

	@PostMapping(value = "/creerAbsence")
	public ResponseEntity<?> save(@RequestBody @Valid AbsenceDto absenceDto, BindingResult result) {//masquer les paramètres pour les avoir dans corps requête
		/*@valid permet de retourner une erreur si les données ne sont conformes à la classe(absence DTO)
		 *Binding result envoie les résultats dans un objet result
		 * On capture les éventuelles erreurs dans une map sous forme : key,
		 * value et formatée pour l'affichage
		 * 
		 */
		try {
			Map<String, Object> map = new HashMap<String, Object>();// construire une HashMap sous forme clé valeur
			if (result.hasErrors()) {
				for (FieldError error : result.getFieldErrors()) { //pour chaque erreur qui fait partie de la propriété result getFieldErrors
					map.put(error.getField(), String.format("%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map); //responseEntity renvoi au front les erreurs.
				}
			} else {
				absenceDto = absenceService.insertAbsence(absenceDto);
			}
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absenceDto);
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
	public ResponseEntity<?> update(@RequestBody @Valid AbsenceDto absenceDto, BindingResult result) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (result.hasErrors()) {
				for (FieldError error : result.getFieldErrors()) {
					map.put(error.getField(), String.format("%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
				absenceDto = absenceService.updateAbsence(absenceDto);
			}
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absenceDto.getNumDemande() + " modifié.");
	}
	
	
	/**
	 * Relance d'une Absence
	 * 
	 * @param d°
	 *            que update
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */

	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value = "/reflateAbsence")
	public ResponseEntity<?> reflate(@RequestBody ObjectNode json) {
		String numDemande = json.get("numDemande").asText();
		AbsenceDto absenceDto;
		try {
			absenceDto = absenceService.reflateAbsence(numDemande);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}
		return ResponseEntity.ok(absenceDto);
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
	public ResponseEntity<?> delete(@RequestBody AbsenceDto absenceDto) {
		try {
			absenceService.deleteAbsence(absenceDto);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absenceDto.getNumDemande() + " supprimé.");
	}
}
