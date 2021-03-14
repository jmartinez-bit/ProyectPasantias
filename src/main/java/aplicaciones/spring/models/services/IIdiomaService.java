package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.DatoLaboral;
import aplicaciones.spring.models.Idioma;

public interface IIdiomaService {

	public List<Idioma> findAll();
	
	public Idioma findById(Long id);
	
	public Idioma save(Idioma idioma);
	
	public void delete(Long id);
	
	public List<Idioma> saveAll(List<Idioma> idiomas);
	
	public List<Idioma> findByDatoLaboralId(DatoLaboral datoLaboral);
	
	public boolean existIdioma(List<Idioma> idiomas, Long id);
	
	public List<Idioma> updateIdioma(List<Idioma> idiomaEdit, List<Idioma> idiomaActual, DatoLaboral datoLaboralActual);
	
	public void deleteAll(List<Idioma> idiomas);
	
}
