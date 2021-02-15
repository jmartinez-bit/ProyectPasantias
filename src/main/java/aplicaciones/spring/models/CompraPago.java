package aplicaciones.spring.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compra_pago")
public class CompraPago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tipo_comp")
	private String tipoComp;
	
	@Column(name = "fecha_comp")
	private Date fechaComp;
	
	@Column(name = "num_serie")
	private String numSerie;
	
	@Column(name = "num_comp")
	private String numComp;
	
	private String comentarios;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "compra_id")
	private Compra compraId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoComp() {
		return tipoComp;
	}

	public void setTipoComp(String tipoComp) {
		this.tipoComp = tipoComp;
	}

	public Date getFechaComp() {
		return fechaComp;
	}

	public void setFechaComp(Date fechaComp) {
		this.fechaComp = fechaComp;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getNumComp() {
		return numComp;
	}

	public void setNumComp(String numComp) {
		this.numComp = numComp;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Compra getCompraId() {
		return compraId;
	}

	public void setCompraId(Compra compraId) {
		this.compraId = compraId;
	}
	
}
