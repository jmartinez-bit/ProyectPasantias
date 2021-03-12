package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.DatoLaboral;
import aplicaciones.spring.models.DatoPersonal;

public interface IDatoLaboralDao extends CrudRepository<DatoLaboral, Long>{

	public DatoLaboral findByDatoPersonalId(DatoPersonal datoPersonal);
	
}
