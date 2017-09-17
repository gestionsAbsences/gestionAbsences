package fr.simplon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;


public class DemandeAbsencesApplication {  // classe de demarage de l'application
	
	private static final Logger logger = LoggerFactory.getLogger(DemandeAbsencesApplication.class);//instancier le logger

	public static void main(String[] args) {
		SpringApplication.run(Config.class, args); // pour dire qu'il ya une classe de confoguration
		
		logger.info("##### Application démarée ######");
	}
}
