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
public class Comprobante implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	@Column(name = "total_comprobante")
	private double totalComprobante;
	
	@Column(name = "titular_tarjeta")
	private String titularTarjeta;
	
	@Column(name = "estado_devolucion")
	private String estadoDevolucion;
	
	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compraId;

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

	public double getTotalComprobante() {
		return totalComprobante;
	}

	public void setTotalComprobante(double totalComprobante) {
		this.totalComprobante = totalComprobante;
	}

	public String getTitularTarjeta() {
		return titularTarjeta;
	}

	public void setTitularTarjeta(String titularTarjeta) {
		this.titularTarjeta = titularTarjeta;
	}

	public String getEstadoDevolucion() {
		return estadoDevolucion;
	}

	public void setEstadoDevolucion(String estadoDevolucion) {
		this.estadoDevolucion = estadoDevolucion;
	}

	public Compra getCompraId() {
		return compraId;
	}

	public void setCompraId(Compra compraId) {
		this.compraId = compraId;
	}
}
