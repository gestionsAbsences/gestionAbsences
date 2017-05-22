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

import fr.simplon.domain.Role;
import fr.simplon.services.RoleService;

/**
 * CRUD des services ROLE
 * 
 * @author JGL
 * 
 */

/*
 * Controlleur pour la gestion des services Role
 * J'ai utilisé le verbe correspondant à l'action 
 * (get : lecture, post : création, put : mise à jour et delete: supression
 * url àsaisir dans le navigateur : localhost:8080/role/nomMethode
 */

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@RestController
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	/**
	 * Liste des services role
	 * 
	 * @return liste des services role
	 */
	
	/*
	 * Affiche la liste des services role
	 * ResponseEntity permet gérer la réponse envoyée au front
	 */
	@GetMapping("listeService")
	public ResponseEntity<?> findAll() {	
		List<Role> role = new ArrayList<Role>();
		try {
		role = (List<Role>) roleService.listeServicesRole();
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(role);
	}
	
	/**
	 * 
	 * Recherche des services Role par le nom
	 * 
	 * @param String nom
	 * 
	 * @return 1 ou  plusieurs entités role 
	 * 
	 */
	
	/*
	 * Cette methode recherche un service Rolepar le nom
	 * Il suffit de rentrer une lettre et la liste des services
	 * contenant cette lettre sera affichée
	 */
	
	@GetMapping("getService")
	public ResponseEntity<?> findByName(@RequestParam(value="nom", defaultValue="") String nom) {	
		List<Role> role = new ArrayList<Role>();
		try {
			role = (List<Role>) roleService.getRole(nom);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(role);
	}
	
	/**
	 * Création de nouveaux services Role
	 * 
	 * @param email et nom du service Role
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [Role role]
	 * et de capter le résultat  [BindingResult result]
	 */
	@PostMapping(value="/creerService", consumes = "application/json")	
	public ResponseEntity<?> save(@Valid Role role, BindingResult result) {			
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
		role =  roleService.insertRole(role);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(role.getValeur()+" créée.");
	}
	
	/**
	 * Mise à jour d'un service Role
	 * 
	 * @param email et nom du service Role
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	
	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value="/updateService")	
	public ResponseEntity<?> update(@Valid Role role, BindingResult result) {			
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
		return ResponseEntity.ok(role.getValeur()+" modifié.");
	}
	
	/**
	 * Supression d'un service Role
	 * @param valeur
	 * @return message de suppression
	 */
	/*
	 * La suppression se fait par la valeur
	 * Le reste de l'action est dans la classe Service
	 */
	@DeleteMapping("deleteService")
	public ResponseEntity<?> delete(Role role) {	
		try {
			roleService.deleteRole(role);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(role.getValeur() + " supprimé.");
	}

}

	


