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
import javax.validation.constraints.NotEmpty;

@Entity
public class Proveedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(nullable = false, unique = true)
	private String codigo;
	
	@Column(name="ruc_dni")
	private String rucDni;
	
	@Column(name="razon_social")
	private String razonSocial;
	
	@Column(name = "fecha_ini")
	@Temporal(TemporalType.DATE)
	private Date fechaIni;
	
	@Column(name="rubro_actividad")
	private String rubroActividad;
	
	private String direccion;
	
	private String departamento;
	
	private String provincia;
	
	private String distrito;
	private String pais;
	private String ubigeo;
	
	@Column(name="direccion_dos")
	private String direccionDos;
	
	@Column(name="departamento_dos")
	private String departamentoDos;
	
	@Column(name="provincia_dos")
	private String provinciaDos;
	
	@Column(name="distrito_dos")
	private String distritoDos;
	
	@Column(name="pais_dos")
	private String paisDos;
	
	@Column(name="ubigeo_dos")
	private String ubigeoDos;
	
	@Column(name="impuesto_asociado")
	private String impuestoAsociado;
	
	@Column(name="tipo_pago")
	private String tipoPago;
	
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
	public String getDireccionDos() {
		return direccionDos;
	}
	public void setDireccionDos(String direccionDos) {
		this.direccionDos = direccionDos;
	}
	public String getDepartamentoDos() {
		return departamentoDos;
	}
	public void setDepartamentoDos(String departamentoDos) {
		this.departamentoDos = departamentoDos;
	}
	public String getProvinciaDos() {
		return provinciaDos;
	}
	public void setProvinciaDos(String provinciaDos) {
		this.provinciaDos = provinciaDos;
	}
	public String getDistritoDos() {
		return distritoDos;
	}
	public void setDistritoDos(String distritoDos) {
		this.distritoDos = distritoDos;
	}
	public String getPaisDos() {
		return paisDos;
	}
	public void setPaisDos(String paisDos) {
		this.paisDos = paisDos;
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
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public String getUbigeoDos() {
		return ubigeoDos;
	}
	public void setUbigeoDos(String ubigeoDos) {
		this.ubigeoDos = ubigeoDos;
	}
	public String getImpuestoAsociado() {
		return impuestoAsociado;
	}
	public void setImpuestoAsociado(String impuestoAsociado) {
		this.impuestoAsociado = impuestoAsociado;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
