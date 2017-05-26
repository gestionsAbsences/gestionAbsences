package fr.simplon.domain.dto;

import java.util.Date;

public class AbsenceDto {
	
	private Date debut;
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
