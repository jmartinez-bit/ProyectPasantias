package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Compra;
import aplicaciones.spring.models.ProductoCompra;

public interface IProductoCompraService {
	
	public List<ProductoCompra> findAll();
	
	public ProductoCompra findById(Long id);
	
	public ProductoCompra save(ProductoCompra productoCompra);
	
	public void delete(Long id);
	
	public void deleteByCompraId(Compra compra);
	
	public List<ProductoCompra> findByCompraId(Compra compra);

	public List<ProductoCompra> saveProductos(List<ProductoCompra> productos);

	public boolean existProductoCompra(List<ProductoCompra> productos, Long id);
	
	public List<ProductoCompra> updateProductoCompra(List<ProductoCompra> productoCompraEdit, List<ProductoCompra> productoCompraActual, Compra compraActual);
	
	public void deleteAll(List<ProductoCompra> productos);

}
