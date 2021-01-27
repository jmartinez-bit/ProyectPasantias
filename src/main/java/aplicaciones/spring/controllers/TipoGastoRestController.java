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

import aplicaciones.spring.models.TipoGasto;
import aplicaciones.spring.models.services.ITipoGastoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class TipoGastoRestController {

	@Autowired
	private ITipoGastoService tipoGastoService;
	
	@GetMapping("/tipogasto")
	public List<TipoGasto> index() {
		return tipoGastoService.findAll();
	}
	
	@GetMapping("/tipogasto/{id}")
	public TipoGasto show(@PathVariable Long id) {
		return tipoGastoService.findById(id);
	}
	
	@PostMapping("/tipogasto")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoGasto create(@RequestBody TipoGasto tipoGasto) {
		return tipoGastoService.save(tipoGasto);
	}
	
	@PutMapping("/tipogasto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public TipoGasto update(@RequestBody TipoGasto tipoGasto, @PathVariable Long id) {
		TipoGasto tipoGastoActual = tipoGastoService.findById(id);
		
		tipoGastoActual.setNombre(tipoGasto.getNombre());
		return tipoGastoService.save(tipoGastoActual);
	}
	
	@DeleteMapping("/tipogasto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		tipoGastoService.delete(id);
	}
}
