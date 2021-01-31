package aplicaciones.spring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Hijo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nom_ape")
	private String nomApe;
	
	@Column(name="fecha_nac")
	private String fechaNac;
	
	private String dni;
	
	@ManyToOne
	@JoinColumn(name = "dato_familiar_id")
	private DatoFamiliar datoFamilarId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomApe() {
		return nomApe;
	}

	public void setNomApe(String nomApe) {
		this.nomApe = nomApe;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public DatoFamiliar getDatoFamilarId() {
		return datoFamilarId;
	}

	public void setDatoFamilarId(DatoFamiliar datoFamilarId) {
		this.datoFamilarId = datoFamilarId;
	}
}
