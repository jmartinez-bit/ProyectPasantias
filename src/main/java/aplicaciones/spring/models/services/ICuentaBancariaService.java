package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.CuentaBancaria;
import aplicaciones.spring.models.Proveedor;

public interface ICuentaBancariaService {

	public List<CuentaBancaria> findAll();
	
	public CuentaBancaria findById(Long id);
	
	public CuentaBancaria save(CuentaBancaria cuentaBancaria);
	
	public void delete(Long id);
	
	public boolean existCuentaBancaria(List<CuentaBancaria> cuentas, Long id);
	
	public List<CuentaBancaria> findByProveedorId(Proveedor proveedorId);
	
	public List<CuentaBancaria> saveCuentas(List<CuentaBancaria> cuentas);
	
	public List<CuentaBancaria> updateCuenta(List<CuentaBancaria> cuentaBancariaEdit, List<CuentaBancaria> cuentaBancariaActual, Proveedor proveedorActual);
	
	public void deleteAll(List<CuentaBancaria> cuentas);
	
	public void deleteByProveedorId(Proveedor proveedor);
	
}
