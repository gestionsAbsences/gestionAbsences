package fr.simplon.webSecurity.utils;

/**
 * Securité de l'application
 */

public enum AuthEnum {
	
	NOAUTH(0),
	EMPLOYE(1),
	RESPONSABLE(2),
	SERVICERH(3),
	ADMIN(4);
	
	private int auth;
	
	private AuthEnum(int auth) {
		this.auth= auth;
	}

	public int getAuth() {
		return auth;
	}
	
	
}
