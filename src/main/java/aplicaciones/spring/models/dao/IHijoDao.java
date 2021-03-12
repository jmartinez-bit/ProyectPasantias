package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Hijo;

public interface IHijoDao extends CrudRepository<Hijo, Long> {

}
