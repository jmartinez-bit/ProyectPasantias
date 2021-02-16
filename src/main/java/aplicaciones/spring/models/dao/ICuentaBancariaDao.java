package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.CuentaBancaria;
import aplicaciones.spring.models.Proveedor;

public interface ICuentaBancariaDao extends CrudRepository<CuentaBancaria, Long>{

	public List<CuentaBancaria> findByProveedorId(Proveedor proveedorId);
	
	public void deleteByProveedorId(Proveedor proveedor);
	
}
