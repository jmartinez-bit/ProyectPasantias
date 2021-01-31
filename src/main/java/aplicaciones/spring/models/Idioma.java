package aplicaciones.spring.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Idioma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String desc;
	private String nivel;
	
	@ManyToOne
	@JoinColumn(name = "dato_laboral_id")
	private DatoLaboral datoLaboralId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public DatoLaboral getDatoLaboralId() {
		return datoLaboralId;
	}

	public void setDatoLaboralId(DatoLaboral datoLaboralId) {
		this.datoLaboralId = datoLaboralId;
	}
}
