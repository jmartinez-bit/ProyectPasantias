package aplicaciones.spring.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.CuentaBancaria;
import aplicaciones.spring.models.Direccion;
import aplicaciones.spring.models.FormProveedor;
import aplicaciones.spring.models.PersonaContacto;
import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.services.ICuentaBancariaService;
import aplicaciones.spring.models.services.IDireccionService;
import aplicaciones.spring.models.services.IPersonaContactoService;
import aplicaciones.spring.models.services.IProveedorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProveedorRestController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@Autowired
	private IPersonaContactoService personaContactoService;
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	@Autowired
	private IDireccionService direccionService;
	
	@GetMapping("/proveedores")
	public List<Proveedor> index() {
		return proveedorService.findAll();
	}
	
	@GetMapping("/proveedores/id")
	public ResponseEntity<?> obtenerId() {
		
		Map<String, Object> response = new HashMap<>();
		response.put("identificador", proveedorService.obtenerIdUltimo());
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/proveedores/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		Proveedor proveedor = proveedorService.findById(id);
		List<Direccion> direcciones = direccionService.findByProveedorId(proveedor);
		List<PersonaContacto> personas = personaContactoService.findByProveedorId(proveedor);
		List<CuentaBancaria> cuentas = cuentaBancariaService.findByProveedorId(proveedor);
		
		response.put("proveedor", proveedor);
		response.put("direccion", direcciones);
		response.put("personaContacto", personas);
		response.put("cuentaBancaria", cuentas);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/proveedores")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create( @RequestBody FormProveedor proveedor) {
		
		Map<String, Object> response = new HashMap<>();
		Proveedor proveedorNuevo = proveedorService.save(proveedor.getProveedor());
		
		List<Direccion> direcciones = proveedor.getDireccion();
		List<Direccion> direccionesNuevas = null;
		if(direcciones != null) {
			for(Direccion direccion : direcciones) {
				direccion.setProveedorId(proveedorNuevo);
			}
			direccionesNuevas = direccionService.saveDireccion(direcciones);
		}
		
		List<PersonaContacto> personas = proveedor.getPersonaContacto();
		List<PersonaContacto> personasNuevas = null;
		if(personas != null) {
			for(PersonaContacto persona : personas) {
				persona.setProveedorId(proveedorNuevo);
			}
			personasNuevas = personaContactoService.savePersonas(personas);
		}
		
		List<CuentaBancaria> cuentas = proveedor.getCuentaBancaria();
		List<CuentaBancaria> cuentasNuevas = null;
		if(cuentas != null) {
			for(CuentaBancaria cuenta : cuentas) {
				cuenta.setProveedorId(proveedorNuevo);
			}
			cuentasNuevas = cuentaBancariaService.saveCuentas(cuentas);
		}
		
		response.put("proveedor", proveedorNuevo);
		response.put("direccion", direccionesNuevas);
		response.put("cuentaBancaria", cuentasNuevas);
		response.put("personaContacto", personasNuevas);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody FormProveedor proveedor, @PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Proveedor proveedorEdit = proveedor.getProveedor();
		Proveedor proveedorActual = proveedorService.findById(id);
		
		proveedorActual.setComentarios(proveedorEdit.getComentarios());
		proveedorActual.setFechaIni(proveedorEdit.getFechaIni());
		proveedorActual.setRazonSocial(proveedorEdit.getRazonSocial());
		proveedorActual.setRubroActividad(proveedorEdit.getRubroActividad());
		proveedorActual.setRucDni(proveedorEdit.getRucDni());
		
		proveedorActual.setImpuestoAsociado(proveedorEdit.getImpuestoAsociado());
		proveedorActual.setTipoPago(proveedorEdit.getTipoPago());
		
		// Actualización para direcciones
		List<Direccion> direccionEdit = proveedor.getDireccion();
		List<Direccion> direccionActual = direccionService.findByProveedorId(proveedorActual);
		List<Direccion> direccionUpdated = direccionService.updateDireccion(direccionEdit, direccionActual, proveedorActual);
		
		// Actualización para personaContacto
		List<PersonaContacto> personaContactoEdit = proveedor.getPersonaContacto();
		List<PersonaContacto> personaContactoActual = personaContactoService.findByProveedorId(proveedorActual);
		List<PersonaContacto> personaContactoUpdated = personaContactoService.updatePersona(personaContactoEdit, personaContactoActual, proveedorActual);
		
		// Actualización para cuentaBancaria
		List<CuentaBancaria> cuentaBancariaEdit = proveedor.getCuentaBancaria();
		List<CuentaBancaria> cuentaBancariaActual = cuentaBancariaService.findByProveedorId(proveedorActual);
		List<CuentaBancaria> cuentaBancariaUpdated = cuentaBancariaService.updateCuenta(cuentaBancariaEdit, cuentaBancariaActual, proveedorActual);
		
		Proveedor proveedorUpdated = proveedorService.save(proveedorActual);
		response.put("proveedor", proveedorUpdated);
		response.put("direccion", direccionUpdated);
		response.put("personaContacto", personaContactoUpdated);
		response.put("cuentaBancaria", cuentaBancariaUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Proveedor proveedor = proveedorService.findById(id);
		direccionService.deleteByProveedorId(proveedor);
		personaContactoService.deleteByProveedorId(proveedor);
		cuentaBancariaService.deleteByProveedorId(proveedor);
		proveedorService.delete(id);
	}
	
	@GetMapping("/proveedores/ruc")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> findByRucDni(@RequestParam (value = "rucDni") String rucDni) {
		Map<String, Object> response = new HashMap<>();
		
		Proveedor proveedor = proveedorService.findByRucDni(rucDni);
		List<Direccion> direcciones = direccionService.findByProveedorId(proveedor);
		List<PersonaContacto> personas = personaContactoService.findByProveedorId(proveedor);
		
		response.put("proveedor", proveedor);
		response.put("direccion", direcciones);
		response.put("personaContacto", personas);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
