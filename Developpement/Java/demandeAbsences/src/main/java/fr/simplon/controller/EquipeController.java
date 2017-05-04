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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.domain.Equipe;
import fr.simplon.services.EquipeService;

/**
 * CRUD des services EQUIPE
 * 
 * @author JGL
 * 
 */

/*
 * Controlleur pour la gestion des services Equipe
 * J'ai utilisé le verbe correspondant à l'action 
 * (get : lecture, post : création, put : mise à jour et delete: supression
 * url àsaisir dans le navigateur : localhost:8080/equipe/nomMethode
 */
@RestController
@RequestMapping("equipe")
public class EquipeController {
	
	@Autowired
	EquipeService equipeService;
	
	/**
	 * Liste des services equipe
	 * 
	 * @return liste des services equipe
	 */
	
	/*
	 * Affiche la liste des services equipe
	 * ResponseEntity permet gérer la réponse envoyée au front
	 */
	@GetMapping("listeService")
	public ResponseEntity<?> findAll() {	
		List<Equipe> equipe = new ArrayList<Equipe>();
		try {
		equipe = (List<Equipe>) equipeService.listeServicesEquipe();
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(equipe);
	}
	
	/**
	 * 
	 * Recherche des services Equipe par le nom
	 * 
	 * @param String nom
	 * 
	 * @return 1 ou  plusieurs entités equipe 
	 * 
	 */
	
	/*
	 * Cette methode recherche un service Equipepar le nom
	 * Il suffit de rentrer une lettre et la liste des services
	 * contenant cette lettre sera affichée
	 */
	
	@GetMapping("getService")
	public ResponseEntity<?> findByName(@RequestParam(value="nom", defaultValue="") String nom) {	
		List<Equipe> equipe = new ArrayList<Equipe>();
		try {
			equipe = (List<Equipe>) equipeService.getEquipe(nom);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(equipe);
	}
	
	/**
	 * Création de nouveaux services Equipe
	 * 
	 * @param email et nom du service Equipe
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [Equipe equipe]
	 * et de capter le résultat  [BindingResult result]
	 */
	@PostMapping(value="/creerService", consumes = "application/json")	
	public ResponseEntity<?> save(@Valid Equipe equipe, BindingResult result) {			
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
		equipe =  equipeService.insertEquipe(equipe);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(equipe.getNom()+" créée.");
	}
	
	/**
	 * Mise à jour d'un service Equipe
	 * 
	 * @param email et nom du service Equipe
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	
	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value="/updateService")	
	public ResponseEntity<?> update(@Valid Equipe equipe, BindingResult result) {			
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
	}
	
	/**
	 * Supression d'un service Equipe
	 * @param nom
	 * @return message de suppression
	 */
	/*
	 * La suppression se fait par le nom
	 * Le reste de l'action est dans la classe Service
	 */
	@DeleteMapping("deleteService")
	public ResponseEntity<?> delete(Equipe equipe) {	
		try {
			equipeService.deleteEquipe(equipe);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(equipe.getNom() + " supprimé.");
	}

}

	


