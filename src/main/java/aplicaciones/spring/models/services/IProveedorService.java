package aplicaciones.spring.models.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aplicaciones.spring.models.Proveedor;

public interface IProveedorService {

	public Page<Proveedor> findAll(Pageable pageable);
	
	public Proveedor findById(Long id);
	
	public Proveedor save(Proveedor proveedor);
	
	public void delete(Long id);
	
	public Long obtenerIdUltimo();
	
	public Proveedor findByRucDni(String rucDni);
	
}
