package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Pago;

public interface IPagoService {
	
	public List<Pago> findAll();
	
	public Pago findById(Long id);
	
	public Pago save(Pago pago);
	
	public void delete(Long id);

}
