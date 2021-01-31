package aplicaciones.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dato_personal")
public class DatoPersonal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	private String nombres;
	
	@Column(name="p_apellido")
	private String pApellido;
	
	@Column(name="s_apellido")
	private String sApellido;
	
	@Column(name="tipo_doc")
	private String tipoDoc;
	
	@Column(name="num_doc")
	private String numDoc;
	
	@Column(name="fecha_nac")
	private Date fechaNac;
	private String nacionalidad;
	private String direccion;
	private String pais;
	private String departamento;
	private String provincia;
	private String distrito;
	private String ubigeo;
	
	@Column(name="telef_fijo")
	private String telefFijo;
	
	@Column(name="telef_movil")
	private String telefMovil;
	
	@Column(name="correo_per")
	private String correoPer;
	
	@Column(name="num_seguro")
	private String numSeguro;
	
	@Column(name="sis_pensiones")
	private String sisPensiones;
	
	@Column(name="op_pensiones")
	private String opPensiones;
	private String cuspp;
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
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getpApellido() {
		return pApellido;
	}
	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;
	}
	public String getsApellido() {
		return sApellido;
	}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
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
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public String getTelefFijo() {
		return telefFijo;
	}
	public void setTelefFijo(String telefFijo) {
		this.telefFijo = telefFijo;
	}
	public String getTelefMovil() {
		return telefMovil;
	}
	public void setTelefMovil(String telefMovil) {
		this.telefMovil = telefMovil;
	}
	public String getCorreoPer() {
		return correoPer;
	}
	public void setCorreoPer(String correoPer) {
		this.correoPer = correoPer;
	}
	public String getNumSeguro() {
		return numSeguro;
	}
	public void setNumSeguro(String numSeguro) {
		this.numSeguro = numSeguro;
	}
	public String getSisPensiones() {
		return sisPensiones;
	}
	public void setSisPensiones(String sisPensiones) {
		this.sisPensiones = sisPensiones;
	}
	public String getOpPensiones() {
		return opPensiones;
	}
	public void setOpPensiones(String opPensiones) {
		this.opPensiones = opPensiones;
	}
	public String getCuspp() {
		return cuspp;
	}
	public void setCuspp(String cuspp) {
		this.cuspp = cuspp;
	}
	
}
