package fr.simplon.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.domain.Statut;
import fr.simplon.services.StatutService;

@RestController
@RequestMapping("/statut")

public class StatutController {
	
	@Autowired
	StatutService statutService;

@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<?> listStatut(@RequestParam(value="search", defaultValue="") String search) {
	Iterable<Statut> listStatut = null;
	try {
		listStatut = statutService.listStatuts(search);
	} catch (Exception e) {
		return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
	}
	return ResponseEntity.status(HttpStatus.OK).body(listStatut);
}


@RequestMapping(value = "/{id}", method = RequestMethod.GET)
public ResponseEntity<?> getStatut(@PathVariable("id") Long id) {
	Statut statut = null;
	try {
		statut = statutService.getStatut(id);
	} catch (Exception e) {
		return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
	}
	if (statut == null) {
		return ResponseError.getErrorMessage(ResponseError.ERROR_NOT_FOUND, "Not found");
	}
	return ResponseEntity.status(HttpStatus.OK).body(statut);
}



@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<?> insertStatut(@Valid @RequestBody Statut statut , Errors errors) {

	if (errors.hasErrors()) {
		return ResponseError.extractErrorWhenIncompletRequest(errors);
	}

	try {
		statut = statutService.insertStatut(statut);
	} catch (Exception e) {
		return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
	}

	return ResponseEntity.status(HttpStatus.OK).body(statut);
}


@RequestMapping(method = RequestMethod.PUT)
public ResponseEntity<?> updateStatut(@Valid @RequestBody Statut statut, Errors errors) {
	
	if (errors.hasErrors()) {
		return ResponseError.extractErrorWhenIncompletRequest(errors);
	}

	try {
		statutService.updateStatut(statut);
	} catch (Exception e) {
		return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
	}
	return ResponseEntity.status(HttpStatus.OK).body(statut);
}

@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deleteStatut(@PathVariable("id") Long id) {

	try {
		statutService.deleteStatut(id);
	} catch (Exception e) {
		return ResponseError.getErrorMessage(ResponseError.ERROR_EXEC, e.getMessage());
	}

	return ResponseEntity.noContent().build();
}



}

