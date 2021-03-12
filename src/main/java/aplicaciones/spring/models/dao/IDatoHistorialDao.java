package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DatoHistorial;

public interface IDatoHistorialDao extends CrudRepository<DatoHistorial, Long> {

}
