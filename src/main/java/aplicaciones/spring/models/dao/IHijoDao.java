package aplicaciones.spring.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DatoFamiliar;
import aplicaciones.spring.models.Hijo;

public interface IHijoDao extends CrudRepository<Hijo, Long> {

	public List<Hijo> findByDatoFamiliarId(DatoFamiliar datoFamiliar);
	
	public void deleteByDatoFamiliarId(DatoFamiliar datoFamiliar);
	
}
