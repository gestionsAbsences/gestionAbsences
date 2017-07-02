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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.domain.Equipe;
import fr.simplon.domain.dto.AbsenceDto;
import fr.simplon.services.ValidationService;

/**
 * Traitement pour la validation des absences
 * N+1 et RH
 * 
 * @author JGL
 *
 */

@RestController 
@RequestMapping("validation") 
@CrossOrigin(origins="*") 
public class ValidationController {
	
	@Autowired
	ValidationService validationService;
	
	@GetMapping("/listeAbsences") 
	public ResponseEntity<?> findAll(@RequestParam(value = "equipe", defaultValue = "") String equipe, 
			@RequestParam(value = "statut", defaultValue="")int statut) {
		List<AbsenceDto> absenceDto;
		try {
			absenceDto =validationService.listeValidation(equipe, statut);
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absenceDto);
	}
	
	
	//Validation des congés
	@PutMapping(value = "/validationAbsence")
	public ResponseEntity<?> update(@RequestBody @Valid AbsenceDto absenceDto, int validation, BindingResult result) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (result.hasErrors()) {
				for (FieldError error : result.getFieldErrors()) {
					map.put(error.getField(), String.format("%s", error.getDefaultMessage()));
					return ResponseEntity.badRequest().body(map);
				}
			} else {
				absenceDto = validationService.updateValidation(absenceDto, validation);
			}
		} catch (SQLException sqle) {
			return ResponseEntity.badRequest().body(sqle);
		}
		return ResponseEntity.ok(absenceDto);
	}
	
	

}
