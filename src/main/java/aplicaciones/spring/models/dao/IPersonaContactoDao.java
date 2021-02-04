package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.PersonaContacto;

public interface IPersonaContactoDao extends CrudRepository<PersonaContacto, Long>{

}
