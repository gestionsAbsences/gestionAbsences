package fr.simplon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * entity Service RH
 * 
 */

@Entity
@Table(name="absence")
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "debut")
	private String debut;

	@Column(name = "fin")
	private String fin;
	
	private Long id_employe;
	private Long id_type;
	private Long id_statut;
	private Long id_service_rh;
	
	public Absence(){}

	public Absence(Long id, String debut, String fin, Long id_employe, Long id_type, Long id_statut, Long id_service_rh) {
		super();
		this.id = id;
		this.debut = debut;
		this.fin = fin;
		this.id_employe = id_employe;
		this.id_type = id_type;
		this.id_statut = id_statut;
		this.id_service_rh = id_service_rh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDebut() {
		return debut;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public Long getId_employe() {
		return id_employe;
	}

	public void setId_employe(Long id_employe) {
		this.id_employe = id_employe;
	}

	public Long getId_type() {
		return id_type;
	}

	public void setId_type(Long id_type) {
		this.id_type = id_type;
	}

	public Long getId_statut() {
		return id_statut;
	}

	public void setId_statut(Long id_statut) {
		this.id_statut = id_statut;
	}

	public Long getId_service_rh() {
		return id_service_rh;
	}

	public void setId_service_rh(Long id_service_rh) {
		this.id_service_rh = id_service_rh;
	}

}
