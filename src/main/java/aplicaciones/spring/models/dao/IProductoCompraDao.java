package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.ProductoCompra;

public interface IProductoCompraDao extends CrudRepository<ProductoCompra, Long>{

}
