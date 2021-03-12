package aplicaciones.spring.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="dato_historial")
public class DatoHistorial implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="cargo_actual")
	private String cargoActual;
	
	@ManyToOne
	@JoinColumn(name = "dato_laboral_id")
	private DatoLaboral datoLaboralId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargoActual() {
		return cargoActual;
	}

	public void setCargoActual(String cargoActual) {
		this.cargoActual = cargoActual;
	}

	public DatoLaboral getDatoLaboralId() {
		return datoLaboralId;
	}

	public void setDatoLaboralId(DatoLaboral datoLaboralId) {
		this.datoLaboralId = datoLaboralId;
	}
}
