package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Compra;
import aplicaciones.spring.models.ProductoCompra;

public interface IProductoCompraDao extends CrudRepository<ProductoCompra, Long>{

	public List<ProductoCompra> findByCompraId(Compra compra);
	
	public void deleteByCompraId(Compra compra);
	
}
