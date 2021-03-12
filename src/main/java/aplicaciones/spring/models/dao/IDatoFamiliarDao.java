package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DatoFamiliar;
import aplicaciones.spring.models.DatoPersonal;

public interface IDatoFamiliarDao extends CrudRepository<DatoFamiliar, Long>{

	public DatoFamiliar findByDatoPersonalId(DatoPersonal datoPersonal);
	
}
