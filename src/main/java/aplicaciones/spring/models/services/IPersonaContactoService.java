package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.PersonaContacto;

public interface IPersonaContactoService {

	public List<PersonaContacto> findAll();
	
	public PersonaContacto findById(Long id);
	
	public PersonaContacto save(PersonaContacto personaContacto);
	
	public void delete(Long id);
	
}
