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

	private int id_employe;
	
	private int id_role;

	@ManyToOne
	@JoinColumn(name="id_role", insertable = false, updatable = false)
	private Role roles;

	@OneToOne
	@JoinColumn(name="id_employe", insertable = false, updatable = false)
	private Employe user_employe;

	
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

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public Employe getUser_employe() {
		return user_employe;
	}

	public void setUser_employe(Employe user_employe) {
		this.user_employe = user_employe;
	}
}
