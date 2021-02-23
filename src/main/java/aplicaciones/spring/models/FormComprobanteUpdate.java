package aplicaciones.spring.models;

import java.util.List;

public class FormComprobanteUpdate {
	
	Comprobante comprobante;
	List<PagoDetalle> pagoDetalle;
	
	public Comprobante getComprobante() {
		return comprobante;
	}
	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}
	public List<PagoDetalle> getPagoDetalle() {
		return pagoDetalle;
	}
	public void setPagoDetalle(List<PagoDetalle> pagoDetalle) {
		this.pagoDetalle = pagoDetalle;
	}
}
