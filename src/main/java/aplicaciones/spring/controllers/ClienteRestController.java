package aplicaciones.spring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import aplicaciones.spring.models.Cliente;
import aplicaciones.spring.models.Direccion;
import aplicaciones.spring.models.FormCliente;
import aplicaciones.spring.models.PersonaContacto;
import aplicaciones.spring.models.services.IClienteService;
import aplicaciones.spring.models.services.IDireccionService;
import aplicaciones.spring.models.services.IPersonaContactoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private IPersonaContactoService personaContactoService;
	
	@Autowired
	private IDireccionService direccionService;
	
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Cliente cliente = clienteService.findById(id);
		List<Direccion> direcciones = direccionService.findByClienteId(cliente);
		List<PersonaContacto> personas = personaContactoService.findByClienteId(cliente);
		
		response.put("cliente", cliente);
		response.put("direccion", direcciones);
		response.put("personaContacto", personas);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody FormCliente cliente) {
		
		Map<String, Object> response = new HashMap<>();
		
		Cliente clienteNuevo = clienteService.save(cliente.getCliente());
		
		List<Direccion> direcciones = cliente.getDireccion();
		List<Direccion> direccionesNuevas = null;
		if(direcciones != null) {			
			for(Direccion direccion : direcciones) {
				direccion.setClienteId(clienteNuevo);
			}
			direccionesNuevas = direccionService.saveDireccion(direcciones);
		}
		
		List<PersonaContacto> personas = cliente.getPersonaContacto();
		List<PersonaContacto> personasNuevas = null;
		if(personas != null) {			
			for(PersonaContacto persona : personas) {
				persona.setClienteId(clienteNuevo);
			}
			personasNuevas = personaContactoService.savePersonas(personas);
		}
		
		response.put("cliente", clienteNuevo);
		response.put("direccion", direccionesNuevas);
		response.put("personaContacto", personasNuevas);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody FormCliente cliente, @PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		// Actualización para cliente
		Cliente clienteEdit = cliente.getCliente();
		Cliente clienteActual = clienteService.findById(id);
		
		clienteActual.setCodigo(clienteEdit.getCodigo());
		clienteActual.setComentarios(clienteEdit.getComentarios());
		clienteActual.setFechaIni(clienteEdit.getFechaIni());
		clienteActual.setRazonSocial(clienteEdit.getRazonSocial());
		clienteActual.setRubroActividad(clienteEdit.getRubroActividad());
		clienteActual.setRucDni(clienteEdit.getRucDni());
		
		
		// Actualización para direcciones
		List<Direccion> direccionEdit = cliente.getDireccion();
		List<Direccion> direccionActual = direccionService.findByClienteId(clienteActual);
		
		List<Direccion> direccionUpdated = direccionService.updateDireccion(direccionEdit, direccionActual, clienteActual);
		
		List<PersonaContacto> personaContactoEdit = cliente.getPersonaContacto();
		List<PersonaContacto> personaContactoActual = personaContactoService.findByClienteId(clienteActual);
		
		List<PersonaContacto> personaContactoUpdated = personaContactoService.updatePersona(personaContactoEdit, personaContactoActual, clienteActual);
		// -----------------------------------------------------------------------------------------	
		
		Cliente clienteUpdated = clienteService.save(clienteActual);
		response.put("cliente", clienteUpdated);
		response.put("direccion", direccionUpdated);
		response.put("personaContacto", personaContactoUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Cliente cliente = clienteService.findById(id);
		direccionService.deleteByClienteId(cliente);
		personaContactoService.deleteByClienteId(cliente);
		clienteService.delete(id);
	}
}
