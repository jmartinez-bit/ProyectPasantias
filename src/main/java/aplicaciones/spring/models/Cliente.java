package aplicaciones.spring.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	@Column(name="ruc_dni")
	private String rucDni;
	
	@Column(name="razon_social")
	private String razonSocial;

	@Column(name="fecha_ini")
	@Temporal(TemporalType.DATE)
	private Date fechaIni;
	
	@Column(name="rubro_actividad")
	private String rubroActividad;
	
	private String comentarios;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRucDni() {
		return rucDni;
	}

	public void setRucDni(String rucDni) {
		this.rucDni = rucDni;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public String getRubroActividad() {
		return rubroActividad;
	}

	public void setRubroActividad(String rubroActividad) {
		this.rubroActividad = rubroActividad;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
}
