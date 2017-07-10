package fr.simplon.webSecurity;

/**
 * Securité de l'application
 */

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class OAuthSecureConfig extends GlobalAuthenticationConfigurerAdapter {

//	@Autowired
//	UserDao userDao;
//	
//	@Override
//	public void init(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailService());
//	}
//	
//	@Bean
//	UserDetailsService userDetailService(){
//		return new UserDetailsService(){
//			
//			@Transactional
//			@Override
//			public UserDetails loadUserByUsername(String email){
//				User user = userDao.findByEmail(email);
//				System.out.println(user.getEmail());
//				if (user != null) {
//					return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPasswd(),getAuthorities(user.getRole()));
//				} else {
//
//					throw new ServiceException("Impossible de trouver le compte :" + email + ".");
//				}
//			}
//		};
//	}
//	
//	// Creation d'un collection d'autorisation a partir d'une liste de role
//		private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
//			List<GrantedAuthority> authorities = new ArrayList<>();
//			authorities.add(new SimpleGrantedAuthority(AuthConstantes.ROLE + role.getValeur()));
//			return authorities;
//		}
//}
