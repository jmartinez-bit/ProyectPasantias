package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.PersonaContacto;

public interface IPersonaContactoDao extends CrudRepository<PersonaContacto, Long>{

	public List<PersonaContacto> findByClienteId(Cliente clienteId);
	
	public void deleteByClienteId(Cliente cliente);
	
}
