package aplicaciones.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.PersonaContacto;
import aplicaciones.spring.models.services.IPersonaContactoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PersonaContactoRestController {

	@Autowired
	private IPersonaContactoService personaContactoService;
	
	@GetMapping("/persona-contacto")
	public List<PersonaContacto> index() {
		return personaContactoService.findAll();
	}
	
	@GetMapping("/persona-contacto/{id}")
	public PersonaContacto show(@PathVariable Long id) {
		return personaContactoService.findById(id);
	}
	
	@PostMapping("/persona-contacto")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonaContacto create(@RequestBody PersonaContacto personaContacto) {
		return personaContactoService.save(personaContacto);
	}
	
	@PutMapping("/persona-contacto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonaContacto update(@RequestBody PersonaContacto personaContacto, @PathVariable Long id) {
		PersonaContacto personaContactoActual = personaContactoService.findById(id);
		
		personaContactoActual.setCargo(personaContacto.getCargo());
		personaContactoActual.setCorreo(personaContacto.getCorreo());
		personaContactoActual.setNombre(personaContacto.getNombre());
		personaContactoActual.setProveedorId(personaContacto.getProveedorId());
		personaContactoActual.setTelefono(personaContacto.getTelefono());
		
		return personaContactoService.save(personaContactoActual);
	}
	
	@DeleteMapping("/persona-contacto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		personaContactoService.delete(id);
	}
	
}
