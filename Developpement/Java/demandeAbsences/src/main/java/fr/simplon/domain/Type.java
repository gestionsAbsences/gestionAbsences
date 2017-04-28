package fr.simplon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Type
 */
@Entity
@Table(name = "Type")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Type {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	// NotBlanck est un validateur d'hibernate
	// Il indique que la propriete nom doit être renseignée
	@Column(name = "nom")
	@NotBlank(message = "nom can't empty!")
	private String nom;


	public Type(Long id, String nom) {
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
