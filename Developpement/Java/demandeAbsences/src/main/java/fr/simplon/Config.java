package fr.simplon;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "fr.simplon.controllers", "fr.simplon.domain"," fr.simplon.dao", "fr.simplon.services" })
@EnableAutoConfiguration
public class Config {

}
