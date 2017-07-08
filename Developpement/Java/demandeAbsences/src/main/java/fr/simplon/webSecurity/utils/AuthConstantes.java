package fr.simplon.webSecurity.utils;

/**
 * Securité de l'application
 */

public class AuthConstantes {
	public static final String EMPLOYE = "hasRole('ROLE_employe')";
	public static final String RESPONSABLE = "hasRole('ROLE_responsable')";
	public static final String SERVICERH = "hasRole('ROLE_servicerh')";
	public static final String ADMIN = "hasRole('ROLE_admin')";
	public static final String ROLE = "ROLE_";
	
	private AuthConstantes() {
	}

}
