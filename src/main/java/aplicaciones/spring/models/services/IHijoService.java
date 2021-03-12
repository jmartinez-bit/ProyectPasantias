package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Hijo;

public interface IHijoService {

	public List<Hijo> findAll();
	
	public Hijo findById(Long id);
	
	public Hijo save(Hijo hijo);
	
	public void delete(Long id);
	
	public List<Hijo> saveAll(List<Hijo> hijos);
	
}
