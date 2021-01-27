package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.TipoGasto;

public interface ITipoGastoDao extends CrudRepository<TipoGasto, Long>{

}
