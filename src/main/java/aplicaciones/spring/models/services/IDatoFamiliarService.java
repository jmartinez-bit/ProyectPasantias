package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.DatoFamiliar;
import aplicaciones.spring.models.DatoPersonal;

public interface IDatoFamiliarService {

	public List<DatoFamiliar> findAll();
	
	public DatoFamiliar findById(Long id);
	
	public DatoFamiliar save(DatoFamiliar datoFamiliar);
	
	public void delete(Long id);
	
	public DatoFamiliar findByDatoPersonal(DatoPersonal datoPersonal);
	
}
