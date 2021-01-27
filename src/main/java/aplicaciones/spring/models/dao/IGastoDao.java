package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Gasto;

public interface IGastoDao extends CrudRepository<Gasto, Long>{

}
