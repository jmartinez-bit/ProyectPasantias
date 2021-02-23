package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DetalleProductoCompra;
import aplicaciones.spring.models.ProductoCompra;

public interface IDetalleProductoCompraDao extends CrudRepository<DetalleProductoCompra, Long> {

	public List<DetalleProductoCompra> findByProductoCompraId(ProductoCompra productoCompra);
	
}
