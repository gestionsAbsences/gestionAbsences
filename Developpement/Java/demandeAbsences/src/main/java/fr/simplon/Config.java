package fr.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration //Cette annotation permet de substituer la classe au traditionnel fichier de configuartion xml
@ComponentScan({ "fr.simplon.controller", "fr.simplon.domain"," fr.simplon.dao", "fr.simplon.services" }) // Scanne les composants de l'application
@EnableAutoConfiguration //Permet l'auto configuration de l'application. Peut être surcharger 

public class Config extends WebMvcConfigurerAdapter{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
}
