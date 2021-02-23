package aplicaciones.spring.models;

import java.util.List;

public class FormDetalleProductoCompra {
	List<DetalleProductoCompra> detalleProductoCompra;

	public List<DetalleProductoCompra> getDetalleProductoCompra() {
		return detalleProductoCompra;
	}

	public void setDetalleProductoCompra(List<DetalleProductoCompra> detalleProductoCompra) {
		this.detalleProductoCompra = detalleProductoCompra;
	}
	
}
