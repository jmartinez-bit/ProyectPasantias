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

import aplicaciones.spring.models.Pago;
import aplicaciones.spring.models.services.IPagoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class PagoRestController {

	@Autowired
	private IPagoService pagoService;
	
	@GetMapping("/pagos")
	public List<Pago> index() {
		return pagoService.findAll();
	}
	
	@GetMapping("/pagos/{id}")
	public Pago show(@PathVariable Long id) {
		return pagoService.findById(id);
	}
	
	@PostMapping("/pagos")
	@ResponseStatus(HttpStatus.CREATED)
	public Pago create(@RequestBody Pago pago) {
		return pagoService.save(pago);
	}
	
	@PutMapping("/pagos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Pago update(@RequestBody Pago pago, @PathVariable Long id) {
		Pago pagoActual = pagoService.findById(id);
		
		pagoActual.setBanco(pago.getBanco());
		pagoActual.setBeneficiario(pago.getBeneficiario());
		pagoActual.setMetodo(pago.getMetodo());
		pagoActual.setNumCheque(pago.getNumOperacion());
		pagoActual.setNumOperacion(pago.getNumOperacion());
		pagoActual.setTitularTarjeta(pago.getTitularTarjeta());
		pagoActual.setGastoId(pago.getGastoId());
		
		return pagoService.save(pagoActual);
	}
	
	@DeleteMapping("/pagos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		pagoService.delete(id);
	}
}
