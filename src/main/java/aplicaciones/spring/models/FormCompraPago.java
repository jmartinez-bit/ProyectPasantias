package aplicaciones.spring.models;

import java.util.List;

public class FormCompraPago {
	
	CompraPago compraPago;
	List<PagoDetalle> pagoDetalle;
	
	public CompraPago getCompraPago() {
		return compraPago;
	}
	public void setCompraPago(CompraPago compraPago) {
		this.compraPago = compraPago;
	}
	public List<PagoDetalle> getPagoDetalle() {
		return pagoDetalle;
	}
	public void setPagoDetalle(List<PagoDetalle> pagoDetalle) {
		this.pagoDetalle = pagoDetalle;
	}
}
