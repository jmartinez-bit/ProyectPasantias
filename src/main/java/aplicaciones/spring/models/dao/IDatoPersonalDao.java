package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DatoPersonal;

public interface IDatoPersonalDao extends CrudRepository<DatoPersonal, Long>{

}
