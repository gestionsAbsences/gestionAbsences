package fr.simplon.webSecurity;

/**
 * Securité de l'application
 */
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired	
//	AuthEntryPoint authEntryPoint;
//	
//	@Autowired
//	AuthSuccessHandler authSuccessHandler;
//	
//	@Autowired
//	AuthFailureHandler authFailureHandler;
//	
//	@Autowired	
//	AuthOutSuccessHandler authOutSuccessHandler;
//	
//	//Override la methode configure
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.httpBasic()
//	  	.and()	
//        	.exceptionHandling()
//  				.authenticationEntryPoint(authEntryPoint)
//  		.and()
//  			.formLogin()
//  				.usernameParameter("email")
//  				.successHandler(authSuccessHandler)
//  				.failureHandler(authFailureHandler)
//  		.and()
//  			.authorizeRequests()
//  			.antMatchers("/api/**").authenticated()
//  		.and()
//	  		.logout()
//	  			.logoutSuccessHandler(authOutSuccessHandler)
//  		.and()
//  			.csrf()
//  			.disable();
//	}
//
//}
