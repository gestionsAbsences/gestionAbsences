package fr.simplon.common;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

/**
 * gestion des erreurs de requete
 *  	permet de retourner une erreur au format Json
 *  	centralise méthodes communes aux controleurs
 * @author simplon
 *
 */
public class ResponseError {

    private int error;
	private String message;
	
	/**
	 * numero d'erreurs
	 * valeurs internes a l'application
	 */
	public final static int ERROR_NOT_FOUND = 10; 
	public final static int ERROR_INCOMPLETE_REQUEST = 40; 
	public final static int ERROR_EXEC = 50; 
	
	
	public ResponseError() {
		super();
	}

	public ResponseError(int error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	
	/**
	 * retourne message d'erreur si erreur de validation
	 * @param errors : liste d'erreurs de validation (
	 * @return : la réponse de la requete
	 */
	public static ResponseEntity<?> extractErrorWhenIncompletRequest(Errors errors) {
		String message = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(","));
		return getErrorMessage(ResponseError.ERROR_INCOMPLETE_REQUEST, message);
	}

	/**
	 * retourne l'erreur 400 (bad request)
	 * @param error : le numero
	 * @param message : le message d'erreur
	 * @return : réponse de la requête
	 */
	public static ResponseEntity<?> getErrorMessage(int error, String message) {
		ResponseError errorResponse = new ResponseError(error,message);
		return ResponseEntity.badRequest().body(errorResponse);
		
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


}
