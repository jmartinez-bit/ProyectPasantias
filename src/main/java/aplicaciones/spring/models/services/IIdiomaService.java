package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Idioma;

public interface IIdiomaService {

	public List<Idioma> findAll();
	
	public Idioma findById(Long id);
	
	public Idioma save(Idioma idioma);
	
	public void delete(Long id);
	
	public List<Idioma> saveAll(List<Idioma> idiomas);
	
}
