package aplicaciones.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ruc_dni")
	private String rucDni;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name = "fecha_ini")
	private Date fechaIni;
	
	@Column(name="rubro_actividad")
	private String rubroActividad;
	
	private String direccion;
	
	private String departamento;
	
	private String provincia;
	
	private String distrito;
	private String pais;
	private String direccion_s;
	private String departamento_s;
	private String provincia_s;
	private String distrito_s;
	private String pais_s;
	private String comentarios;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getRubroActividad() {
		return rubroActividad;
	}
	public void setRubroActividad(String rubroActividad) {
		this.rubroActividad = rubroActividad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDireccion_s() {
		return direccion_s;
	}
	public void setDireccion_s(String direccion_s) {
		this.direccion_s = direccion_s;
	}
	public String getDepartamento_s() {
		return departamento_s;
	}
	public void setDepartamento_s(String departamento_s) {
		this.departamento_s = departamento_s;
	}
	public String getProvincia_s() {
		return provincia_s;
	}
	public void setProvincia_s(String provincia_s) {
		this.provincia_s = provincia_s;
	}
	public String getDistrito_s() {
		return distrito_s;
	}
	public void setDistrito_s(String distrito_s) {
		this.distrito_s = distrito_s;
	}
	public String getPais_s() {
		return pais_s;
	}
	public void setPais_s(String pais_s) {
		this.pais_s = pais_s;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
}
