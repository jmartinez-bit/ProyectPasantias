package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
}
