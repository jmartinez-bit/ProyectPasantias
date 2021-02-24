package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Compra;
import aplicaciones.spring.models.Proveedor;

public interface ICompraService {
	
	public List<Compra> findAll();
	
	public Compra findById(Long id);
	
	public Compra save(Compra compra);
	
	public void delete(Long id);

	public void deleteByProveedorId(Proveedor proveedor);
	
}
