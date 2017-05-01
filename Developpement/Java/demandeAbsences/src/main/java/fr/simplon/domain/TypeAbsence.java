package fr.simplon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * entity Type
 */
@Entity
@Table(name = "type")
public class TypeAbsence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nom")
	@NotBlank(message = "nom can't empty!")
	@Length(min = 1, message = "La chaîne doit avoir au moins 2 caractères")
	private String nom;


	public TypeAbsence() {
	}


	public TypeAbsence(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
