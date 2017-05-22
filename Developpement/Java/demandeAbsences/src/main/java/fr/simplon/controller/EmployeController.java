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

import fr.simplon.domain.Employe;
import fr.simplon.services.EmployeService;

/**
 * CRUD des services EMPLOYE
 * 
 * @author JGL
 * 
 */

/*
 * Controlleur pour la gestion des services Employe
 * J'ai utilisé le verbe correspondant à l'action 
 * (get : lecture, post : création, put : mise à jour et delete: supression
 * url àsaisir dans le navigateur : localhost:8080/employe/nomMethode
 */

//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="*")
@RestController
@RequestMapping("employe")
public class EmployeController {
	
	@Autowired
	EmployeService employeService;
	
	/**
	 * Liste des services employe
	 * 
	 * @return liste des services employe
	 */
	
	/*
	 * Affiche la liste des services employe
	 * ResponseEntity permet gérer la réponse envoyée au front
	 */
	@GetMapping("listeService")
	public ResponseEntity<?> findAll() {	
		List<Employe> employe = new ArrayList<Employe>();
		try {
		employe = (List<Employe>) employeService.listeServicesEmploye();
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(employe);
	}
	
	/**
	 * 
	 * Recherche des services Employe par le nom
	 * 
	 * @param String nom
	 * 
	 * @return 1 ou  plusieurs entités employe 
	 * 
	 */
	
	/*
	 * Cette methode recherche un service Employepar le nom
	 * Il suffit de rentrer une lettre et la liste des services
	 * contenant cette lettre sera affichée
	 */
	
	@GetMapping("getService")
	public ResponseEntity<?> findByName(@RequestParam(value="nom", defaultValue="") String nom) {	
		List<Employe> employe = new ArrayList<Employe>();
		try {
			employe = (List<Employe>) employeService.getEmploye(nom);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(employe);
	}
	
	/**
	 * Création de nouveaux services Employe
	 * 
	 * @param email et nom du service Employe
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	/*
	 * La 2° ligne permet d'enregistrer les données dans le bean [Employe employe]
	 * et de capter le résultat  [BindingResult result]
	 */
	@PostMapping(value="/creerService", consumes = "application/json")	
	public ResponseEntity<?> save(@Valid Employe employe, BindingResult result) {			
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
		employe =  employeService.insertEmploye(employe);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(employe.getNom()+" créée.");
	}
	
	/**
	 * Mise à jour d'un service Employe
	 * 
	 * @param email et nom du service Employe
	 * 
	 * @return enregistrement ou erreur de saisie
	 * 
	 */
	
	/*
	 * La mise à jour suis le même principe que la création
	 */
	@PutMapping(value="/updateService")	
	public ResponseEntity<?> update(@Valid Employe employe, BindingResult result) {			
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(result.hasErrors()){
				for(FieldError error : result.getFieldErrors()){
					map.put(error.getField(), String.format("message:%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
		employe =  employeService.updateEmploye(employe);
		}
		} catch( SQLException sqle){
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(employe.getNom()+" modifié.");
	}
	
	/**
	 * Supression d'un service Employe
	 * @param nom
	 * @return message de suppression
	 */
	/*
	 * La suppression se fait par le nom
	 * Le reste de l'action est dans la classe Service
	 */
	@DeleteMapping("deleteService")
	public ResponseEntity<?> delete(Employe employe) {	
		try {
			employeService.deleteEmploye(employe);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(employe.getNom() + " supprimé.");
	}

}
