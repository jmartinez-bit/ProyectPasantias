package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Concepto;

public interface IConceptoService {
	
	public List<Concepto> findAll();
	
	public Concepto findById(Long id);
	
	public Concepto save(Concepto concepto);
	
	public void delete(Long id);

}
