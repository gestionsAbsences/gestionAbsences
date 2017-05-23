package fr.simplon.common;

public class EmailException extends RuntimeException {
	
	public EmailException (){
		super("L'adresse email est déjà utilisé");
	}
}
