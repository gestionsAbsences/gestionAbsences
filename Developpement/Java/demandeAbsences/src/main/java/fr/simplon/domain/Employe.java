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
import javax.persistence.OneToOne;
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
	
	private int nbCa;
	private int nbRtt;
	private int nbRc;
	private int reliquatCa;
	private int reliquatRtt;
	private int idEquipe;
	private int idServiceRh;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employes")
	@JsonBackReference
	private List<Absence> absences;

	@ManyToOne
	@JoinColumn(name="idServiceRh", insertable = false, updatable = false)
	private ServiceRh gestionnaireRh;

	@ManyToOne
	@JoinColumn(name="idEquipe", insertable = false, updatable = false)
	private Equipe equipes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "responsables")
	@JsonBackReference
	private List<Equipe> respEquipes;

	@OneToOne
	@JoinColumn(name="id", insertable = false, updatable = false)
	private User users;


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

	public int getNbCa() {
		return nbCa;
	}

	public void setNbCa(int nbCa) {
		this.nbCa = nbCa;
	}

	public int getNbRtt() {
		return nbRtt;
	}

	public void setNbRtt(int nbRtt) {
		this.nbRtt = nbRtt;
	}

	public int getNbRc() {
		return nbRc;
	}

	public void setNbRc(int nbRc) {
		this.nbRc = nbRc;
	}

	public int getReliquatCa() {
		return reliquatCa;
	}

	public void setReliquatCa(int reliquatCa) {
		this.reliquatCa = reliquatCa;
	}

	public int getReliquatRtt() {
		return reliquatRtt;
	}

	public void setReliquatRtt(int reliquatRtt) {
		this.reliquatRtt = reliquatRtt;
	}

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public int getIdServiceRh() {
		return idServiceRh;
	}

	public void setIdServiceRh(int idServiceRh) {
		this.idServiceRh = idServiceRh;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	public ServiceRh getGestionnaireRh() {
		return gestionnaireRh;
	}

	public void setGestionnaireRh(ServiceRh gestionnaireRh) {
		this.gestionnaireRh = gestionnaireRh;
	}

	public Equipe getEquipes() {
		return equipes;
	}

	public void setEquipes(Equipe equipes) {
		this.equipes = equipes;
	}

	public List<Equipe> getRespEquipes() {
		return respEquipes;
	}

	public void setRespEquipes(List<Equipe> respEquipes) {
		this.respEquipes = respEquipes;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
}
