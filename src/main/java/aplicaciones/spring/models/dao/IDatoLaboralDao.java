package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DatoLaboral;

public interface IDatoLaboralDao extends CrudRepository<DatoLaboral, Long>{

}
