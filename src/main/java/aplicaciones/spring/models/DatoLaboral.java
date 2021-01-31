package aplicaciones.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dato_laboral")
public class DatoLaboral implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String historial;
	
	@Column(name="fecha_ing")
	private Date fechaIng;
	
	@Column(name="fecha_ini_cargo")
	private Date fechaIniCargo;
	
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	private String profesion;
	
	@Column(name="year_ing")
	private String yearIng;
	
	@Column(name="year_egr")
	private String yearEgr;
	
	@Column(name="cent_estudios")
	private String centEstudios;
	
	@Column(name="n_academico")
	private String nAcademico;
	
	private String curriculum;
	
	@OneToOne
	@JoinColumn(name = "dato_personal_id")
	private DatoPersonal datoPersonalId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	public Date getFechaIng() {
		return fechaIng;
	}

	public void setFechaIng(Date fechaIng) {
		this.fechaIng = fechaIng;
	}

	public Date getFechaIniCargo() {
		return fechaIniCargo;
	}

	public void setFechaIniCargo(Date fechaIniCargo) {
		this.fechaIniCargo = fechaIniCargo;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getYearIng() {
		return yearIng;
	}

	public void setYearIng(String yearIng) {
		this.yearIng = yearIng;
	}

	public String getYearEgr() {
		return yearEgr;
	}

	public void setYearEgr(String yearEgr) {
		this.yearEgr = yearEgr;
	}

	public String getCentEstudios() {
		return centEstudios;
	}

	public void setCentEstudios(String centEstudios) {
		this.centEstudios = centEstudios;
	}

	public String getnAcademico() {
		return nAcademico;
	}

	public void setnAcademico(String nAcademico) {
		this.nAcademico = nAcademico;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public DatoPersonal getDatoPersonalId() {
		return datoPersonalId;
	}

	public void setDatoPersonalId(DatoPersonal datoPersonalId) {
		this.datoPersonalId = datoPersonalId;
	}
	
}
