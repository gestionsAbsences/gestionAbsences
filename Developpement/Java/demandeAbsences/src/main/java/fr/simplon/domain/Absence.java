package fr.simplon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Service ABSENCE
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

	@JsonIgnore
	private int idEmploye;
	@JsonIgnore
	private int idType;
	@JsonIgnore
	private int idStatut;
	@JsonIgnore
	private int idServiceRh;

	@ManyToOne
	@JoinColumn(name="idType", insertable = false, updatable = false)
	private TypeAbsence types;

	@ManyToOne
	@JoinColumn(name="idStatut", insertable = false, updatable = false)
	private Statut statuts;

	@ManyToOne
	@JoinColumn(name="idServiceRh", insertable = false, updatable = false)
	private ServiceRh valideurRh;

	@ManyToOne
	@JoinColumn(name="idEmploye", insertable = false, updatable = false)
	private Employe employes;


	public Absence(){}

	public Absence(Long id, String debut, String fin, int idEmploye, int idType, int idStatut, int idServiceRh) {
		super();
		this.id = id;
		this.debut = debut;
		this.fin = fin;
		this.idEmploye = idEmploye;
		this.idType = idType;
		this.idStatut = idStatut;
		this.idServiceRh = idServiceRh;
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

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public int getIdStatut() {
		return idStatut;
	}

	public void setIdStatut(int idStatut) {
		this.idStatut = idStatut;
	}

	public int getIdServiceRh() {
		return idServiceRh;
	}

	public void setIdServiceRh(int idServiceRh) {
		this.idServiceRh = idServiceRh;
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

	public ServiceRh getValideurRh() {
		return valideurRh;
	}

	public void setValideurRh(ServiceRh valideurRh) {
		this.valideurRh = valideurRh;
	}

	public Employe getEmployes() {
		return employes;
	}

	public void setEmployes(Employe employes) {
		this.employes = employes;
	}

}
