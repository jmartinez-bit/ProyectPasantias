package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.DatoLaboral;

public interface IDatoLaboralService {

	public List<DatoLaboral> findAll();
	
	public DatoLaboral findById(Long id);
	
	public DatoLaboral save(DatoLaboral datoLaboral);
	
	public void delete(Long id);
}
