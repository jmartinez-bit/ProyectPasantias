package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.PagoDetalle;

public interface IPagoDetalleDao extends CrudRepository<PagoDetalle, Long> {

}
