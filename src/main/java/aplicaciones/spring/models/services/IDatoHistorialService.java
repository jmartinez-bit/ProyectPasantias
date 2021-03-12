package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.DatoHistorial;

public interface IDatoHistorialService {

	public List<DatoHistorial> findAll();
	
	public DatoHistorial findById(Long id);
	
	public DatoHistorial save(DatoHistorial datoHistorial);
	
	public void delete(Long id);
}
