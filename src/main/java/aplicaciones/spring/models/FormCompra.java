package aplicaciones.spring.models;

import java.util.List;

public class FormCompra {
	Compra compra;
	List<ProductoCompra> productoCompra;
	
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public List<ProductoCompra> getProductoCompra() {
		return productoCompra;
	}
	public void setProductoCompra(List<ProductoCompra> productoCompra) {
		this.productoCompra = productoCompra;
	}
}
