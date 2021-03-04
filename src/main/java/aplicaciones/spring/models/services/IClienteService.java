package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aplicaciones.spring.models.Cliente;

public interface IClienteService {

	public Page<Cliente> findAll(Pageable pageable);
	
	public List<Cliente> findAllCliente();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public Long obtenerIdUltimo();
	
}
