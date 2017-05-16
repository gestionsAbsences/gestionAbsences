package fr.simplon.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Statut
 * 
 * @author Simplon
 *
 */
@Entity
@Table(name = "Statut")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Statut {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nom")
	@NotBlank(message = "nom obligatoire!")
	private String nom;

	@Column(name = "code")
	@NotBlank(message = "code obligatoire")
	private int code;

	@OneToMany(mappedBy = "statut")
	@JsonBackReference
	private List<Absence> absence;

	public Statut() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Absence> getAbsence() {
		return absence;
	}

	public void setAbsence(List<Absence> absence) {
		this.absence = absence;
	}
	
}


