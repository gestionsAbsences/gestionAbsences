package fr.simplon.domain.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Entity AbsenceDto
 * 
 * Classe pour l'envoi et la reception
 * 
 * de données au front
 * 
 * @author JGL
 *
 */

public class AbsenceDto {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Future(message = "La date doit être postérieure à la date du jour")
	private Date debut;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Future(message = "La date doit être postérieure à la date du jour")
	private Date fin;
	
	private String type;
	
	private String statut;
	
	public AbsenceDto() {
	}

	public Date getDebut() {
		return debut;
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	

}
