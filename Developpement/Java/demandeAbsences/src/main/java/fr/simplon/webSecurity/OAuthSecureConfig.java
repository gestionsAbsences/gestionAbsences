package fr.simplon.webSecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
<<<<<<< HEAD
=======
import org.springframework.security.core.userdetails.UsernameNotFoundException;
>>>>>>> master

import fr.simplon.dao.UserDao;
import fr.simplon.domain.Role;
import fr.simplon.domain.User;
<<<<<<< HEAD
import fr.simplon.exception.ServiceException;
=======
>>>>>>> master
import fr.simplon.webSecurity.utils.AuthConstantes;

/**
 * Securité de l'application
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OAuthSecureConfig extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UserDao userDao;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService());
	}
	
	@Bean
	UserDetailsService userDetailService(){
		return new UserDetailsService(){
			
			@Transactional
			@Override
			public UserDetails loadUserByUsername(String email){
<<<<<<< HEAD
				User user = (User) userDao.findByEmail(email);
=======
				User user = userDao.findByEmail(email);
>>>>>>> master
				
				if (user != null) {
					return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswd(),getAuthorities(user.getRole()));
				} else {

<<<<<<< HEAD
					throw new ServiceException("Impossible de trouver le compte :" + email + ".");
=======
					throw new UsernameNotFoundException("Impossible de trouver le compte :" + email + ".");
>>>>>>> master
				}
			}
		};
	}
	
	// Creation d'un collection d'autorisation a partir d'une liste de role
		private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(AuthConstantes.ROLE + role.getValeur()));
			return authorities;
		}
}
<<<<<<< HEAD
=======


>>>>>>> master
