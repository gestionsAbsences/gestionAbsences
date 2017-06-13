package fr.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;


@Configuration
@ComponentScan({ "fr.simplon.controller", "fr.simplon.domain"," fr.simplon.dao", "fr.simplon.services" })
@EnableAutoConfiguration

public class Config extends WebMvcConfigurerAdapter{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * Configuration de Thymeleaf pour utiliser des fichiers xml
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/template/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setCacheable(true);
		return templateResolver;
	}
	
	@Bean
	SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}
	
	
//	
//	 private ApplicationContext applicationContext;
//
//
//	    @Override
//	    public void setApplicationContext(ApplicationContext applicationContext) {
//	        this.applicationContext = applicationContext;
//	    }
//
//
//
//
//	    /* ******************************************************************* */
//	    /*  GENERAL CONFIGURATION ARTIFACTS                                    */
//	    /*  Static Resources, i18n Messages, Formatters (Conversion Service)   */
//	    /* ******************************************************************* */
//
//	    /*
//	     *  Message externalization/internationalization
//	     */
//	    @Bean
//	    public ResourceBundleMessageSource messageSource() {
//	        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//	        messageSource.setBasename("Messages");
//	        return messageSource;
//	    }
//
//
//	    /* **************************************************************** */
//	    /*  THYMELEAF-SPECIFIC ARTIFACTS                                    */
//	    /*  TemplateResolver <- TemplateEngine <- ViewResolver              */
//	    /* **************************************************************** */
//
//	    @Bean
//	    public SpringResourceTemplateResolver templateResolver(){
//	        // SpringResourceTemplateResolver automatically integrates with Spring's own
//	        // resource resolution infrastructure, which is highly recommended.
//	        final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//	        templateResolver.setApplicationContext(this.applicationContext);
//	        templateResolver.setPrefix("/WEB-INF/templates/");
//	        templateResolver.setSuffix(".html");
//	        // HTML is the default value, added here for the sake of clarity.
//	        templateResolver.setTemplateMode("HTML5");
//	        // Template cache is true by default. Set to false if you want
//	        // templates to be automatically updated when modified.
//	        templateResolver.setCacheable(true);
//	        return templateResolver;
//	    }
//
//	    @Bean
//	    public SpringTemplateEngine templateEngine(){
//	        // SpringTemplateEngine automatically applies SpringStandardDialect and
//	        // enables Spring's own MessageSource message resolution mechanisms.
//	        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//	        templateEngine.setTemplateResolver(templateResolver());
//	        // Enabling the SpringEL compiler with Spring 4.2.4 or newer can
//	        // speed up execution in most scenarios, but might be incompatible
//	        // with specific cases when expressions in one template are reused
//	        // across different data types, so this flag is "false" by default
//	        // for safer backwards compatibility.
////	        templateEngine.setEnableSpringELCompiler(true);
//	        return templateEngine;
//	    }
//
//	    @Bean
//	    public ThymeleafViewResolver viewResolver(){
//	        final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	        viewResolver.setTemplateEngine(templateEngine());
//	        return viewResolver;
//	    }

}
