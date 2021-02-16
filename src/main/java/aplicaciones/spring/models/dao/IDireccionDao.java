package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.Direccion;
import aplicaciones.spring.models.Proveedor;

public interface IDireccionDao extends CrudRepository<Direccion, Long>{

	public List<Direccion> findByClienteId(Cliente clienteId);
	
	public void deleteByClienteId(Cliente cliente);
	
	public List<Direccion> findByProveedorId(Proveedor proveedorId);
	
	public void deleteByProveedorId(Proveedor proveedor);
	
}
