package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Proveedor;

public interface IProveedorService {

	public List<Proveedor> findAll();
	
	public Proveedor findById(Long id);
	
	public Proveedor save(Proveedor proveedor);
	
	public void delete(Long id);
	
	public Long obtenerIdUltimo();
	
	public Proveedor findByRucDni(String rucDni);
	
}
