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

	private int id_hierarchie;
	private int id_responsable;

	@ManyToOne
	@JoinColumn(name="id_hierarchie", insertable = false, updatable = false)
	private Equipe parent;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipes")
	@JsonBackReference
	private List<Employe> employes;


	public Equipe(){}

	public Equipe(Long id, String nom, int id_hierarchie, int id_responsable, Equipe parent) {
		super();
		this.id = id;
		this.nom = nom;
		this.id_hierarchie = id_hierarchie;
		this.id_responsable = id_responsable;
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

	public int getId_hierarchie() {
		return id_hierarchie;
	}

	public void setId_hierarchie(int id_hierarchie) {
		this.id_hierarchie = id_hierarchie;
	}

	public int getId_responsable() {
		return id_responsable;
	}

	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
}
