package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.DetalleProductoCompra;
import aplicaciones.spring.models.ProductoCompra;

public interface IDetalleProductoCompraService {
	
	public List<DetalleProductoCompra> findAll();
	
	public DetalleProductoCompra findById(Long id);
	
	public DetalleProductoCompra save(DetalleProductoCompra detalleProductoCompra);
	
	public void delete(Long id);
	
	public List<DetalleProductoCompra> updateDetalleCompra(List<DetalleProductoCompra> detalleEdit, List<DetalleProductoCompra> detalleActual);
	
	public List<DetalleProductoCompra> saveDetalleCompra(List<DetalleProductoCompra> detalleProductoCompra);

	public List<DetalleProductoCompra> findByProductoCompra(ProductoCompra productoCompra);
	
}
