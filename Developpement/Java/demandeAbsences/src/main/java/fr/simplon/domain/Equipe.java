package fr.simplon.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * entity Service EQUIPE
 * 
 */

@Entity
@Table(name="equipe")
public class Equipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nom")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 4, message = "La chaîne doit avoir au moins 4 caractères")
	private String nom;

	private int idHierarchie;
	private int idResponsable;

	@ManyToOne
	@JoinColumn(name="idHierarchie", insertable = false, updatable = false)
	private Equipe parent;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipes")
	@JsonBackReference
	private List<Employe> employes;

	@ManyToOne
	@JoinColumn(name="idResponsable", insertable = false, updatable = false)
	private Employe responsables;


	public Equipe(){}

	public Equipe(Long id, String nom, int idHierarchie, int idResponsable, Equipe parent) {
		super();
		this.id = id;
		this.nom = nom;
		this.idHierarchie = idHierarchie;
		this.idResponsable = idResponsable;
		this.parent = parent;
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

	public Equipe getParent() {
		return parent;
	}

	public void setParent(Equipe parent) {
		this.parent = parent;
	}

	public int getIdHierarchie() {
		return idHierarchie;
	}

	public void setIdHierarchie(int idHierarchie) {
		this.idHierarchie = idHierarchie;
	}

	public int getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Employe getResponsables() {
		return responsables;
	}

	public void setResponsables(Employe responsables) {
		this.responsables = responsables;
	}
}
