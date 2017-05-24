package fr.simplon.common;

public class EmailException extends RuntimeException {
	
	/**
	 * @category Gestion des exceptions
	 * 
	 * @author JGL
	 */
	private static final long serialVersionUID = 1L;

	public EmailException (){
		super("L'adresse email est déjà utilisé");
	}
}
