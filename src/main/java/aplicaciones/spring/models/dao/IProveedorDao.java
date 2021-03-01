package aplicaciones.spring.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import aplicaciones.spring.models.Proveedor;

public interface IProveedorDao extends PagingAndSortingRepository<Proveedor, Long>{

	Proveedor findTopByOrderByIdDesc();
	
	public Proveedor findByRucDni(String rucDni);
	
	public Page<Proveedor> findAll(Pageable pageable);
	
}
