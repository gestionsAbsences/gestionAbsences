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
 * entity Role
 * 
 */

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "valeur")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 4, message = "La chaîne doit avoir au moins 4 caractères")
	private String valeur;
	

	public Role(){}

	public Role(Long id, String valeur) {
		super();
		this.id = id;
		this.valeur = valeur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

}
