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
import fr.simplon.domain.Absence;
import fr.simplon.services.AbsenceService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/absence")
public class AbsenceController {
   
	@Autowired
	AbsenceService absenceService;

	@RequestMapping(value = "/listeAbsence", method = RequestMethod.GET)
	public ResponseEntity<?> listeAbsences(@RequestParam(value="searchnew", defaultValue="") String searchnew) {
		Iterable<Absence> listeAbsence = null;
		try {
			listeAbsence = absenceService.listeAbsences(searchnew);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(listeAbsence);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getAbsence(@PathVariable("id") Long id) {
		Absence absence = null;
		try {
			absence = absenceService.getAbsence(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}
		if (absence == null) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_NOT_FOUND, "Aucun enregistrement");
		}
		return ResponseEntity.status(HttpStatus.OK).body(absence);
	}

	
	 
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@Valid Absence absence, BindingResult errors) {

		
		if (errors.hasErrors()) {
			return ResponseError.extractErrorWhenIncompletRequest(errors);
		}

		try {
			absence = absenceService.insertAbsence(absence);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.OK).body(absence);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateAbsence(@Valid Absence absence, BindingResult result) throws Exception {
	

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

	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAbsence(@PathVariable("id") Long id) {

		try {
			absenceService.deleteAbsence(id);
		} catch (Exception e) {
			return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
		}

		return ResponseEntity.noContent().build();
	}

	
}
