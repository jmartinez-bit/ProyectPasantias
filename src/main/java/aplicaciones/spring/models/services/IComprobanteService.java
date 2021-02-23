package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Comprobante;

public interface IComprobanteService {

	public List<Comprobante> findAll();
	
	public Comprobante findById(Long id);
	
	public Comprobante save(Comprobante comprobante);
	
	public void delete(Long id);
	
}
