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

import aplicaciones.spring.models.Gasto;
import aplicaciones.spring.models.services.IGastoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class GastoRestController {
	
	@Autowired
	private IGastoService gastoService;
	
	@GetMapping("/gastos")
	public List<Gasto> index() {
		return gastoService.findAll();
	}
	
	@GetMapping("/gastos/{id}")
	public Gasto show(@PathVariable Long id) {
		return gastoService.findById(id);
	}

	@PostMapping("/gastos")
	@ResponseStatus(HttpStatus.CREATED)
	public Gasto create(@RequestBody Gasto gasto) {
		return gastoService.save(gasto);
	}
	
	@PutMapping("/gastos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Gasto update(@RequestBody Gasto gasto, @PathVariable Long id) {
		Gasto gastoActual = gastoService.findById(id);
		
		gastoActual.setCodigo(gasto.getCodigo());
		gastoActual.setConceptoId(gasto.getConceptoId());
		gastoActual.setDescripcion(gasto.getDescripcion());
		gastoActual.setDireccion(gasto.getDireccion());
		gastoActual.setEstadoPago(gasto.getEstadoPago());
		gastoActual.setFecha(gasto.getFecha());
		gastoActual.setFechaVenc(gasto.getFechaVenc());
		gastoActual.setIgv(gasto.getIgv());
		gastoActual.setNumDocumento(gasto.getNumDocumento());
		gastoActual.setPrecioVenta(gasto.getPrecioVenta());
		gastoActual.setTipoDocumento(gasto.getTipoDocumento());
		gastoActual.setTipoGastoId(gasto.getTipoGastoId());
		gastoActual.setValorVenta(gasto.getValorVenta());
		
		return gastoService.save(gastoActual);
	}
	
	@DeleteMapping("/gastos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		gastoService.delete(id);
	}
}
