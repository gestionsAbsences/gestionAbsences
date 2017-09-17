package fr.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication  //configuration automatique de l'application(gèrent les dépendances)
public class Config extends WebMvcConfigurerAdapter{ // pour dire que l'on faitdu web et mvc
	
	@Autowired
	JdbcTemplate jdbcTemplate; //connexion à la base de données
	
}
