package aplicaciones.spring.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Concepto implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "tipo_gasto_id")
	private TipoGasto tipoGastoId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoGasto getTipoGastoId() {
		return tipoGastoId;
	}

	public void setTipoGastoId(TipoGasto tipoGastoId) {
		this.tipoGastoId = tipoGastoId;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
