package fr.simplon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Service USER
 * 
 */

@Entity
@Table(name="user")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email")
	@NotBlank(message = "Nom obligatoire")
	@Email
	private String email;

	@Column(name = "password")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 8, message = "La chaîne doit avoir au moins 8 caractères")
	private String password;

	private int idEmploye;
	
	private int idRole;

	@ManyToOne
	@JoinColumn(name="idRole", insertable = false, updatable = false)
	private Role roles;

	@OneToOne
	@JoinColumn(name="idEmploye", insertable = false, updatable = false)
	private Employe userEmploye;

	
	public User(){}

	public User(Long id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public Employe getUserEmploye() {
		return userEmploye;
	}

	public void setUserEmploye(Employe userEmploye) {
		this.userEmploye = userEmploye;
	}
}
