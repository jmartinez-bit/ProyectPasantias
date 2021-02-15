package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Comprobante;

public interface IComprobanteDao extends CrudRepository<Comprobante, Long> {

}
