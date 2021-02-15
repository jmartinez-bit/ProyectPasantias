package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
