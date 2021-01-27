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

@Entity
public class Gasto implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String codigo;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(name="num_documento")
	private String numDocumento;
	private Date fecha;
	private String direccion;
	private String descripcion;
	
	@Column(name="valor_venta")
	private double valorVenta;
	private double igv;
	
	@Column(name="precio_venta")
	private double precioVenta;
	
	@Column(name="estado_pago")
	private String estadoPago;
	
	@Column(name="fecha_venc")
	private Date fechaVenc;
	
	@OneToOne
	@JoinColumn(name = "tipo_gasto_id")
	private TipoGasto tipoGastoId;
	
	@OneToOne
	@JoinColumn(name = "concepto_id")
	private Concepto conceptoId;
	
	@OneToOne
	@JoinColumn(name = "pago_id")
	private Pago pagoId;

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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Date getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public TipoGasto getTipoGastoId() {
		return tipoGastoId;
	}

	public void setTipoGastoId(TipoGasto tipoGastoId) {
		this.tipoGastoId = tipoGastoId;
	}

	public Concepto getConceptoId() {
		return conceptoId;
	}

	public void setConceptoId(Concepto conceptoId) {
		this.conceptoId = conceptoId;
	}

	public Pago getPagoId() {
		return pagoId;
	}

	public void setPagoId(Pago pagoId) {
		this.pagoId = pagoId;
	}
	
}
