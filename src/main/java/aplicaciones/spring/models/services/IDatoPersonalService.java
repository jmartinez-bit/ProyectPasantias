package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.DatoPersonal;

public interface IDatoPersonalService {
	
	public List<DatoPersonal> findAll();
	
	public DatoPersonal findById(Long id);
	
	public DatoPersonal save(DatoPersonal datoPersonal);
	
	public void delete(Long id);

}
