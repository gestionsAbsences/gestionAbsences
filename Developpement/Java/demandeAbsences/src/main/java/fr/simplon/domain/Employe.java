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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * entity Service EMPLOYE
 * 
 */

@Entity
@Table(name="employe")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nom")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 2, message = "La chaîne doit avoir au moins 2 caractères")
	private String nom;

	@Column(name = "prenom")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 2, message = "La chaîne doit avoir au moins 2 caractères")
	private String prenom;

	@Column(name = "matricule")
	@NotBlank(message = "Nom obligatoire")
	@Length(min = 3, message = "La chaîne doit avoir au moins 3 caractères")
	private String matricule;
	
	private int nb_cp;
	private int nb_rtt;
	private int nb_rc;
	private int reliquat_ca;
	private int reliquat_rtt;
	private int id_equipe;
	private int id_service_rh;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employes")
	@JsonBackReference
	private List<Absence> absences;

	@ManyToOne
	@JoinColumn(name="id_service_rh", insertable = false, updatable = false)
	private ServiceRh emprhs;

	@ManyToOne
	@JoinColumn(name="id_equipe", insertable = false, updatable = false)
	private Equipe equipes;


	public Employe(){}

	public Employe(Long id, String nom, String prenom, String matricule) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public int getNb_cp() {
		return nb_cp;
	}

	public void setNb_cp(int nb_cp) {
		this.nb_cp = nb_cp;
	}

	public int getNb_rtt() {
		return nb_rtt;
	}

	public void setNb_rtt(int nb_rtt) {
		this.nb_rtt = nb_rtt;
	}

	public int getNb_rc() {
		return nb_rc;
	}

	public void setNb_rc(int nb_rc) {
		this.nb_rc = nb_rc;
	}

	public int getReliquat_ca() {
		return reliquat_ca;
	}

	public void setReliquat_ca(int reliquat_ca) {
		this.reliquat_ca = reliquat_ca;
	}

	public int getReliquat_rtt() {
		return reliquat_rtt;
	}

	public void setReliquat_rtt(int reliquat_rtt) {
		this.reliquat_rtt = reliquat_rtt;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public int getId_service_rh() {
		return id_service_rh;
	}

	public void setId_service_rh(int id_service_rh) {
		this.id_service_rh = id_service_rh;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public ServiceRh getEmprhs() {
		return emprhs;
	}

	public void setEmprhs(ServiceRh emprhs) {
		this.emprhs = emprhs;
	}

	public Equipe getEquipes() {
		return equipes;
	}

	public void setEquipes(Equipe equipes) {
		this.equipes = equipes;
	}
}
