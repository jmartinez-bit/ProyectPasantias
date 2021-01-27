package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Concepto;

public interface IConceptoDao extends CrudRepository<Concepto, Long>{

}
