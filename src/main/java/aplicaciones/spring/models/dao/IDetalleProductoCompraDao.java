package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DetalleProductoCompra;

public interface IDetalleProductoCompraDao extends CrudRepository<DetalleProductoCompra, Long> {

}
