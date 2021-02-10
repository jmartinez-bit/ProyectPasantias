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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.CuentaBancaria;
import aplicaciones.spring.models.FormProveedor;
import aplicaciones.spring.models.PersonaContacto;
import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.services.ICuentaBancariaService;
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
	public Proveedor show(@PathVariable Long id) {
		return proveedorService.findById(id);
	}
	
	@PostMapping("/proveedores")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create( @RequestBody FormProveedor formproveedor) {
		
		Map<String, Object> response = new HashMap<>();
		Proveedor proveedorNuevo = proveedorService.save(formproveedor.getProveedor());
		
		PersonaContacto personaContacto = formproveedor.getPersonaContacto();
		CuentaBancaria cuentaBancaria = formproveedor.getCuentaBancaria();
		
		personaContacto.setProveedorId(proveedorNuevo);
		cuentaBancaria.setProveedorId(proveedorNuevo);
		
		PersonaContacto personaContactoNuevo = personaContactoService.save(personaContacto);
		CuentaBancaria cuentaBancariaNuevo = cuentaBancariaService.save(cuentaBancaria);
		
		response.put("proveedor", proveedorNuevo);
		response.put("personaContacto", personaContactoNuevo);
		response.put("cuentaBancaria", cuentaBancariaNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor update(@RequestBody Proveedor proveedor, @PathVariable Long id) {
		Proveedor proveedorActual = proveedorService.findById(id);
		
		proveedorActual.setComentarios(proveedor.getComentarios());
		proveedorActual.setDepartamento(proveedor.getDepartamento());
		proveedorActual.setDepartamentoDos(proveedor.getDepartamentoDos());
		proveedorActual.setDireccion(proveedor.getDireccion());
		proveedorActual.setDireccionDos(proveedor.getDireccionDos());
		proveedorActual.setDistrito(proveedor.getDistrito());
		proveedorActual.setDistritoDos(proveedor.getDistritoDos());
		proveedorActual.setFechaIni(proveedor.getFechaIni());
		proveedorActual.setPais(proveedor.getPais());
		proveedorActual.setPaisDos(proveedor.getPaisDos());
		proveedorActual.setProvincia(proveedor.getProvincia());
		proveedorActual.setProvinciaDos(proveedor.getProvinciaDos());
		proveedorActual.setRazonSocial(proveedor.getRazonSocial());
		proveedorActual.setRubroActividad(proveedor.getRubroActividad());
		proveedorActual.setRucDni(proveedor.getRucDni());
		
		proveedorActual.setUbigeo(proveedor.getUbigeo());
		proveedorActual.setUbigeoDos(proveedor.getUbigeoDos());
		proveedorActual.setImpuestoAsociado(proveedor.getImpuestoAsociado());
		proveedorActual.setTipoPago(proveedor.getTipoPago());
		
		return proveedorService.save(proveedorActual);
	}
	
	@DeleteMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		proveedorService.delete(id);
	}

}
