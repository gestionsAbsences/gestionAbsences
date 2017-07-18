package fr.simplon.webSecurity.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Component;
>>>>>>> master

/**
 * Securité de l'application
 */
<<<<<<< HEAD
=======
@Component
>>>>>>> master
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response
			, Authentication Auth) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);

	}

}
