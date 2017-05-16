package fr.simplon.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * entity Role
 */
@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "valeur")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 1, message = "La chaîne doit avoir au moins 2 caractères")
	private int valeur;
	
	@OneToMany(mappedBy = "role")
	@JsonBackReference
	private List<User> user;


	public Role() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getValeur() {
		return valeur;
	}


	public void setValeur(int valeur) {
		this.valeur = valeur;
	}


	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}

}
