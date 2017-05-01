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
 */
@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "role")
	@NotBlank(message = "role can't empty!")
	@Length(min = 1, message = "La chaîne doit avoir au moins 2 caractères")
	private String role;


	public Role() {
	}


	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}


	public Long getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
