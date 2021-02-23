package aplicaciones.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.Comprobante;
import aplicaciones.spring.models.FormComprobanteUpdate;
import aplicaciones.spring.models.PagoDetalle;
import aplicaciones.spring.models.services.IComprobanteService;
import aplicaciones.spring.models.services.IPagoDetalleService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ComprobanteRestController {
	
	@Autowired
	private IComprobanteService comprobanteService;
	
	@Autowired
	private IPagoDetalleService pagoDetalleService;

	@GetMapping("/comprobantes")
	public List<Comprobante> index() {
		return comprobanteService.findAll();
	}
	
	@GetMapping("/comprobantes/{id}")
	public Comprobante show(@PathVariable Long id) {
		return comprobanteService.findById(id);
	}
	
	@PostMapping("/comprobantes")
	@ResponseStatus(HttpStatus.CREATED)
	public Comprobante create(@RequestBody Comprobante comprobante) {
		return comprobanteService.save(comprobante);
	}
	
	/*
	 * @PutMapping("/categorias/{id}")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public ResponseEntity<?>
	 * update(@RequestBody FormComprobanteUpdate comprobante, @PathVariable Long id)
	 * {
	 * 
	 * Map<String, Object> response = new HashMap<>();
	 * 
	 * Comprobante comprobanteEdit = comprobante.getComprobante(); Comprobante
	 * comprobanteActual = comprobanteService.findById(id);
	 * 
	 * comprobanteActual.setEstadoDevolucion(comprobanteEdit.getEstadoDevolucion());
	 * 
	 * List<PagoDetalle> pagoDetalleEdit = comprobante.getPagoDetalle(); }
	 */
	
}
