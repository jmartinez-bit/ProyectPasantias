package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.CompraPago;

public interface ICompraPagoService {

	public List<CompraPago> findAll();
	
	public CompraPago findById(Long id);
	
	public CompraPago save(CompraPago compraPago);
	
	public void delete(Long id);
	
}
