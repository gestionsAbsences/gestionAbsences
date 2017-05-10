package fr.simplon.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Service RH
 * 
 */

@Entity
@Table(name="service_rh")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class ServiceRh {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email")
	@NotBlank(message = "Email obligatoire")
	@Email(regexp="^[a-zA-Z0-9._-]+@[a-z0-9.-_]{2,}.[a-z]{2,4}$")
	private String email;

	@Column(name = "nom")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 4, message = "La chaîne doit avoir au moins 4 caractères")
	private String nom;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rhs")
	@JsonBackReference
	private List<Absence> absences;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emprhs")
	@JsonBackReference
	private List<Employe> rhemps;


	public ServiceRh(){}

	public ServiceRh(Long id, String email, String nom) {
		super();
		this.id = id;
		this.email = email;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public List<Employe> getRhemps() {
		return rhemps;
	}

	public void setRhemps(List<Employe> rhemps) {
		this.rhemps = rhemps;
	}

}
