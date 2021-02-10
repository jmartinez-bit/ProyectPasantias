package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Proveedor;

public interface IProveedorDao extends CrudRepository<Proveedor, Long>{

	Proveedor findTopByOrderByIdDesc();
}
