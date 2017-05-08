package fr.simplon.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;

/**
 * entity Service RH
 * 
 */

@Entity
@Table(name="absence")
public class Absence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "debut_abs")
    @Future(message = "Il faut une date postérieure à aujourd'hui") //Ça évite de taper une date antérieur à la date du jour
    private Date debut_abs;

    @Column(name = "fin_abs")
    private Date fin_abs;

    @Column(name = "id_employe")
    private int id_employe;

    @Column(name = "id_type")
    private int  id_type;

    @Column(name = "id_Statut")
    private int id_statut;
    
    @Column(name = "id_service_rh")
    private int id_service_rh;

	
	public Absence(){}

	public Absence(Long id, Date debut_abs, Date fin_abs, int id_employe, int id_type, int id_statut, int id_service_rh) {
		super();
		this.id = id;
		this.debut_abs = debut_abs;
		this.fin_abs = fin_abs;
		this.id_employe = id_employe;
		this.id_type = id_type;
		this.id_statut = id_statut;
		this.id_service_rh = id_service_rh;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDebut_abs() {
		return debut_abs;
	}

	public void setDebut_abs(Date debut_abs) {
		this.debut_abs = debut_abs;
	}

	public Date getFin_abs() {
		return fin_abs;
	}

	public void setFin_abs(Date fin_abs) {
		this.fin_abs = fin_abs;
	}

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

	public int getId_type() {
		return id_type;
	}

	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	public int getId_statut() {
		return id_statut;
	}

	public void setId_statut(int id_statut) {
		this.id_statut = id_statut;
	}

	public int getId_service_rh() {
		return id_service_rh;
	}

	public void setId_service_rh(int id_service_rh) {
		this.id_service_rh = id_service_rh;
	}

	}
