package fr.simplon.domain;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Absence
 * 
 * @author Simplon
 *
 */

@Entity
@Table(name = "absence")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "debut")
	private Date debut;

	@Column(name = "fin")
	private Date fin;
	
	@ManyToOne
	@JoinColumn(name = "id_employe")
	private Employe employe;

	@ManyToOne
	@JoinColumn(name = "id_type")
	private TypeAbsence type;

	@ManyToOne
	@JoinColumn(name = "id_statut")
	private Statut statut;

	@ManyToOne
	@JoinColumn(name = "id_service_rh")
	private ServiceRh valideurRh;

	public Absence() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public TypeAbsence getType() {
		return type;
	}

	public void setType(TypeAbsence type) {
		this.type = type;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public ServiceRh getValideurRh() {
		return valideurRh;
	}

	public void setValideurRh(ServiceRh valideurRh) {
		this.valideurRh = valideurRh;
	}


	

}
