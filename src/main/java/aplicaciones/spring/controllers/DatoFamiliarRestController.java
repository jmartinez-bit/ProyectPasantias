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

import aplicaciones.spring.models.DatoFamiliar;
import aplicaciones.spring.models.services.IDatoFamiliarService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DatoFamiliarRestController {
	
	@Autowired
	private IDatoFamiliarService datoFamiliarService;
	
	@GetMapping("/dato-familiar")
	public List<DatoFamiliar> index() {
		return datoFamiliarService.findAll();
	}
	
	@GetMapping("/dato-familiar/{id}")
	public DatoFamiliar show(@PathVariable Long id) {
		return datoFamiliarService.findById(id);
	}

	@PostMapping("/dato-familiar")
	@ResponseStatus(HttpStatus.CREATED)
	public DatoFamiliar create(@RequestBody DatoFamiliar datoFamiliar) {
		return datoFamiliarService.save(datoFamiliar);
	}
	
	@PutMapping("/dato-familiar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public DatoFamiliar update(@RequestBody DatoFamiliar datoFamiliar, @PathVariable Long id) {
		DatoFamiliar datoFamiliarActual = datoFamiliarService.findById(id);
		datoFamiliarActual.setDatoPersonalId(datoFamiliar.getDatoPersonalId());
		datoFamiliarActual.setDepartamento(datoFamiliar.getDepartamento());
		datoFamiliarActual.setDireccion(datoFamiliar.getDireccion());
		datoFamiliarActual.setDistrito(datoFamiliar.getDistrito());
		datoFamiliarActual.setEstadoCivil(datoFamiliar.getEstadoCivil());
		datoFamiliarActual.setFechaNac(datoFamiliar.getFechaNac());
		datoFamiliarActual.setNombres(datoFamiliar.getNombres());
		datoFamiliarActual.setPais(datoFamiliar.getPais());
		datoFamiliarActual.setpApellido(datoFamiliar.getpApellido());
		datoFamiliarActual.setPerContacto(datoFamiliar.getPerContacto());
		datoFamiliarActual.setProvincia(datoFamiliar.getProvincia());
		datoFamiliarActual.setRelacion(datoFamiliar.getRelacion());
		datoFamiliarActual.setsApellido(datoFamiliar.getsApellido());
		datoFamiliarActual.setUbigeo(datoFamiliar.getUbigeo());
		
		return datoFamiliarService.save(datoFamiliarActual);
	}
	
	@DeleteMapping("/dato-familiar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		datoFamiliarService.delete(id);
	}

}
