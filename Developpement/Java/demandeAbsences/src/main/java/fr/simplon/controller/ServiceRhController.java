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

import fr.simplon.domain.ServiceRh;
import fr.simplon.services.ServiceRhService;

/**
 * CRUD des services RH
 * 
 * @author JGL
 * 
 */

/*
 * Controlleur pour la gestion des services Rh
 * J'ai utilisé le verbe correspondant à l'action 
 * (get : lecture, post : création, put : mise à jour et delete: supression
 * url àsaisir dans le navigateur : localhost:8080/rh/nomMethode
 */

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@RestController
@RequestMapping("rh")
public class ServiceRhController {
	
	@Autowired
	ServiceRhService rhService;
	
	/**
	 * Liste des services rh
	 * 
	 * @return liste des services rh
	 */
	
	/*
	 * Affiche la liste des services rh
	 * ResponseEntity permet gérer la réponse envoyée au front
	 */
	@GetMapping("listeService")
	public ResponseEntity<?> findAll() {	
		List<ServiceRh> serviceRh = new ArrayList<ServiceRh>();
		try {
		serviceRh = (List<ServiceRh>) rhService.listeServicesRh();
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(serviceRh);
	}
	
	/**
	 * 
	 * Recherche des services Rh par le nom
	 * 
	 * @param String nom
	 * 
	 * @return 1 ou  plusieurs entités rh 
	 * 
	 */
	
	/*
	 * Cette methode recherche un service Rhpar le nom
	 * Il suffit de rentrer une lettre et la liste des services
	 * contenant cette lettre sera affichée
	 */
	
	@GetMapping("getService")
	public ResponseEntity<?> findByName(@RequestParam(value="nom", defaultValue="") String nom) {	
		List<ServiceRh> serviceRh = new ArrayList<ServiceRh>();
		try {
			serviceRh = (List<ServiceRh>) rhService.getServiceRh(nom);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(serviceRh);
	}
	
	/**
	 * Création de nouveaux services Rh
	 * 
	 * @param email et nom du service Rh
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [ServiceRh serviceRh]
	 * et de capter le résultat  [BindingResult result]
	 */
	@PostMapping(value="/creerService", consumes = "application/json")	
	public ResponseEntity<?> save(@Valid ServiceRh serviceRh, BindingResult result) {			
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
		serviceRh =  rhService.insertServiceRh(serviceRh);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(serviceRh.getNom()+" créée.");
	}
	
	/**
	 * Mise à jour d'un service Rh
	 * 
	 * @param email et nom du service Rh
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	
	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value="/updateService")	
	public ResponseEntity<?> update(@Valid ServiceRh serviceRh, BindingResult result) {			
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(result.hasErrors()){
				for(FieldError error : result.getFieldErrors()){
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
		serviceRh =  rhService.updateServiceRh(serviceRh);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(serviceRh.getNom()+" modifié.");
	}
	
	/**
	 * Supression d'un service Rh
	 * @param nom
	 * @return message de suppression
	 */
	/*
	 * La suppression se fait par le nom
	 * Le reste de l'action est dans la classe Service
	 */
	@DeleteMapping("deleteService")
	public ResponseEntity<?> delete(ServiceRh serviceRh) {	
		try {
			rhService.deleteServiceRh(serviceRh);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(serviceRh.getNom() + " supprimé.");
	}

}

	


