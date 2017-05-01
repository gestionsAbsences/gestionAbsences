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
 * entity Equipe
 */
@Entity
@Table(name = "equipe")
public class Equipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nom")
	@NotBlank(message = "nom can't empty!")
	@Length(min = 1, message = "La chaîne doit avoir au moins 2 caractères")
	private String nom;

	@Column(name = "id_Responsable")
	private Long id_Responsable;

	@Column(name = "id_EquipeMere")
	private Long id_EquipeMere;


	public Equipe() {
	}

	public Equipe(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Equipe(Long id, String nom, Long id_Responsable, Long id_EquipeMere) {
		super();
		this.id = id;
		this.nom = nom;
		this.id_Responsable = id_Responsable;
		this.id_EquipeMere = id_EquipeMere;
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
	public Long getId_Responsable() {
		return id_Responsable;
	}

	public void setId_Responsable(Long id_Responsable) {
		this.id_Responsable = id_Responsable;
	}

	public Long getId_EquipeMere() {
		return id_EquipeMere;
	}

	public void setId_EquipeMere(Long id_EquipeMere) {
		this.id_EquipeMere = id_EquipeMere;
	}

}
