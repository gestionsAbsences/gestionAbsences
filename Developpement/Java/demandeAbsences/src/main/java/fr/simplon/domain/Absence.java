package fr.simplon.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Service Absence
 * 
 */

@Entity
@Table(name="absence")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "debut")
	private String debut;

	@Column(name = "fin")
	private String fin;

	private int id_employe;
	private int id_type;
	private int id_statut;
	private int id_service_rh;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id_type", insertable = false, updatable = false)
	@JsonManagedReference
	private TypeAbsence types;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id_statut", insertable = false, updatable = false)
	@JsonManagedReference
	private Statut statuts;

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id_service_rh", insertable = false, updatable = false)
	@JsonManagedReference
	private ServiceRh rhs;


	public Absence(){}

	public Absence(Long id, String debut, String fin, int id_employe, int id_type, int id_statut, int id_service_rh) {
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

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public int getId_statut() {
		return id_statut;
	}

	public void setId_statut(int id_statut) {
		this.id_statut = id_statut;
	}

	public int getId_service_rh() {
		return id_service_rh;
	}

	public void setId_service_rh(int id_service_rh) {
		this.id_service_rh = id_service_rh;
	}

	public TypeAbsence getTypes() {
		return types;
	}

	public void setTypes(TypeAbsence types) {
		this.types = types;
	}

	public Statut getStatuts() {
		return statuts;
	}

	public void setStatuts(Statut statuts) {
		this.statuts = statuts;
	}

	public ServiceRh getRhs() {
		return rhs;
	}

	public void setRhs(ServiceRh rhs) {
		this.rhs = rhs;
	}

}
