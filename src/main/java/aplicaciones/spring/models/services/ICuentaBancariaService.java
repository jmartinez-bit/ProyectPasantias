package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.CuentaBancaria;

public interface ICuentaBancariaService {

	public List<CuentaBancaria> findAll();
	
	public CuentaBancaria findById(Long id);
	
	public CuentaBancaria save(CuentaBancaria cuentaBancaria);
	
	public void delete(Long id);
	
}
