package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DatoLaboral;
import aplicaciones.spring.models.Idioma;

public interface IIdiomaDao extends CrudRepository<Idioma, Long> {

	public List<Idioma> findByDatoLaboralId(DatoLaboral datoLaboral);
	
	public void deleteByDatoLaboralId(DatoLaboral datoLaboral);
	
}
