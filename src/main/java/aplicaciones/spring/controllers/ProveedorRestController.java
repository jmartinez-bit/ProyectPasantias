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

import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.services.IProveedorService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProveedorRestController {
	
	@Autowired
	private IProveedorService proveedorService;
	
	@GetMapping("/proveedores")
	public List<Proveedor> index() {
		return proveedorService.findAll();
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedor show(@PathVariable Long id) {
		return proveedorService.findById(id);
	}
	
	@PostMapping("/proveedores")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor create(@RequestBody Proveedor proveedor) {
		return proveedorService.save(proveedor);
	}
	
	@PutMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Proveedor update(@RequestBody Proveedor proveedor, @PathVariable Long id) {
		Proveedor proveedorActual = proveedorService.findById(id);
		
		proveedorActual.setComentarios(proveedor.getComentarios());
		proveedorActual.setDepartamento(proveedor.getDepartamento());
		proveedorActual.setDepartamento_s(proveedor.getDepartamento_s());
		proveedorActual.setDireccion(proveedor.getDireccion());
		proveedorActual.setDireccion_s(proveedor.getDireccion_s());
		proveedorActual.setDistrito(proveedor.getDistrito());
		proveedorActual.setDistrito_s(proveedor.getDistrito_s());
		proveedorActual.setFechaIni(proveedor.getFechaIni());
		proveedorActual.setPais(proveedor.getPais());
		proveedorActual.setPais_s(proveedor.getPais_s());
		proveedorActual.setProvincia(proveedor.getProvincia());
		proveedorActual.setProvincia_s(proveedor.getProvincia_s());
		proveedorActual.setRazonSocial(proveedor.getRazonSocial());
		proveedorActual.setRubroActividad(proveedor.getRubroActividad());
		proveedorActual.setRucDni(proveedor.getRucDni());
		
		return proveedorService.save(proveedorActual);
	}
	
	@DeleteMapping("/proveedores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		proveedorService.delete(id);
	}

}
