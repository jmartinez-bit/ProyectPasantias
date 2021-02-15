package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.Direccion;

public interface IDireccionService {

	public List<Direccion> findAll();
	
	public Direccion findById(Long id);
	
	public Direccion save(Direccion direccion);
	
	public void delete(Long id);
	
	public List<Direccion> saveDireccion(List<Direccion> direcciones);
	
	public List<Direccion> findByClienteId(Cliente clienteId);
	
	public boolean existDireccion(List<Direccion> direcciones, Long id);
	
	public void deleteAll(List<Direccion> direcciones);
	
	public List<Direccion> updateDireccion(List<Direccion> direccionEdit, List<Direccion> direccionActual, Cliente clienteActual);
	
}
