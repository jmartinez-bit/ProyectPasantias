package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.PersonaContacto;

public interface IPersonaContactoService {

	public List<PersonaContacto> findAll();
	
	public PersonaContacto findById(Long id);
	
	public PersonaContacto save(PersonaContacto personaContacto);
	
	public void delete(Long id);
	
	public List<PersonaContacto> savePersonas(List<PersonaContacto> personas);
	
	public List<PersonaContacto> findByClienteId(Cliente cliente);
	
	public boolean existPersonaContacto(List<PersonaContacto> personas, Long id);
	
	public void deleteAll(List<PersonaContacto> personas);
	
	public List<PersonaContacto> updatePersona(List<PersonaContacto> personaContactoEdit, List<PersonaContacto> personaContactoActual, Cliente clienteActual);
	
}
