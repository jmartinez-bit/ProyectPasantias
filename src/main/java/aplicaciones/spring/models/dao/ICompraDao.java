package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Compra;
import aplicaciones.spring.models.Proveedor;

public interface ICompraDao extends CrudRepository<Compra, Long> {

	public void deleteByProveedorId(Proveedor proveedor);
	
}
