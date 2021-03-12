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
@Table(name="dato_familiar")
public class DatoFamiliar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="estado_civil")
	private String estadoCivil;
	
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
	
	@Column(name="per_contacto")
	private String perContacto;
	
	@Column(name="num_contacto")
	private String numContacto;
	private String relacion;
	
	@OneToOne
	@JoinColumn(name = "dato_personal_id")
	private DatoPersonal datoPersonalId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
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

	public String getPerContacto() {
		return perContacto;
	}

	public void setPerContacto(String perContacto) {
		this.perContacto = perContacto;
	}

	public String getRelacion() {
		return relacion;
	}

	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}

	public DatoPersonal getDatoPersonalId() {
		return datoPersonalId;
	}

	public void setDatoPersonalId(DatoPersonal datoPersonalId) {
		this.datoPersonalId = datoPersonalId;
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNumContacto() {
		return numContacto;
	}

	public void setNumContacto(String numContacto) {
		this.numContacto = numContacto;
	}

}
