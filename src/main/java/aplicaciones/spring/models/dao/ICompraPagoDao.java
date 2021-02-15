package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.CompraPago;

public interface ICompraPagoDao extends CrudRepository<CompraPago, Long> {

}
