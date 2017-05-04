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

import fr.simplon.domain.TypeAbsence;
import fr.simplon.services.TypeService;

/**
 * CRUD des services TYPE
 * 
 * @author JGL
 * 
 */

/*
 * Controlleur pour la gestion des services Type
 * J'ai utilisé le verbe correspondant à l'action 
 * (get : lecture, post : création, put : mise à jour et delete: supression
 * url àsaisir dans le navigateur : localhost:8080/type/nomMethode
 */
@RestController
@RequestMapping("type")
public class TypeController {
	
	@Autowired
	TypeService typeService;
	
	/**
	 * Liste des services type
	 * 
	 * @return liste des services type
	 */
	
	/*
	 * Affiche la liste des services type
	 * ResponseEntity permet gérer la réponse envoyée au front
	 */
	@GetMapping("listeService")
	public ResponseEntity<?> findAll() {	
		List<TypeAbsence> listType = new ArrayList<TypeAbsence>();
		try {
			listType = (List<TypeAbsence>) typeService.listeServicesType();
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(listType);
	}
	
	/**
	 * 
	 * Recherche des services Type par le nom
	 * 
	 * @param String nom
	 * 
	 * @return 1 ou  plusieurs entités type 
	 * 
	 */
	
	/*
	 * Cette methode recherche un service Typepar le nom
	 * Il suffit de rentrer une lettre et la liste des services
	 * contenant cette lettre sera affichée
	 */
	
	@GetMapping("getService")
	public ResponseEntity<?> findByName(@RequestParam(value="nom", defaultValue="") String nom) {	
		List<TypeAbsence> typeTrouve = new ArrayList<TypeAbsence>();
		try {
			typeTrouve = (List<TypeAbsence>) typeService.getType(nom);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(typeTrouve);
	}
	
	/**
	 * Création de nouveaux services Type
	 * 
	 * @param email et nom du service Type
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [Type type]
	 * et de capter le résultat  [BindingResult result]
	 */
	@PostMapping(value="/creerService", consumes = "application/json")	
	public ResponseEntity<?> save(@Valid TypeAbsence typeCree, BindingResult result) {			
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
				typeCree =  typeService.insertType(typeCree);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(typeCree.getNom()+" créée.");
	}
	
	/**
	 * Mise à jour d'un service Type
	 * 
	 * @param email et nom du service Type
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	
	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value="/updateService")	
	public ResponseEntity<?> update(@Valid TypeAbsence typeModifie, BindingResult result) {			
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(result.hasErrors()){
				for(FieldError error : result.getFieldErrors()){
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
				typeModifie =  typeService.updateType(typeModifie);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(typeModifie.getNom()+" modifié.");
	}
	
	/**
	 * Supression d'un service Type
	 * @param nom
	 * @return message de suppression
	 */
	/*
	 * La suppression se fait par le nom
	 * Le reste de l'action est dans la classe Service
	 */
	@DeleteMapping("deleteService")
	public ResponseEntity<?> delete(TypeAbsence typeEfface) {	
		try {
			typeService.deleteType(typeEfface);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(typeEfface.getNom() + " supprimé.");
	}

}

	


