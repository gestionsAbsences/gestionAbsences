package fr.simplon.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * entity Absence
 */
@Entity
@Table(name = "absence")
public class Absence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "debut_abs")
	private Long debut_abs;
	@Column(name = "fin_abs")
	private Long fin_abs;
	@Column(name = "id_employe")
	private Long id_employe;
	@Column(name = "id_type")
	private Long  id_type;
	@Column(name = "id_Statut")
	private Long id_statut;
	
	public Absence() {
	}


	public Absence(Long id) {
		super();
		this.id = id;
	
	}


	public Long getDebut_abs() {
		return debut_abs;
	}


	public void setDebut_abs(Long debut_abs) {
		this.debut_abs = debut_abs;
	}


	public Long getFin_abs() {
		return fin_abs;
	}


	public void setFin_abs(Long fin_abs) {
		this.fin_abs = fin_abs;
	}


	public Long getId_employe() {
		return id_employe;
	}


	public void setId_employe(Long id_employe) {
		this.id_employe = id_employe;
	}


	public Long getId_type() {
		return id_type;
	}


	public void setId_type(Long id_type) {
		this.id_type = id_type;
	}


	public Long getId_statut() {
		return id_statut;
	}


	public void setId_statut(Long id_statut) {
		this.id_statut = id_statut;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
}

