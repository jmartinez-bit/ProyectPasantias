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

import aplicaciones.spring.models.CompraPago;
import aplicaciones.spring.models.FormCompraPago;
import aplicaciones.spring.models.PagoDetalle;
import aplicaciones.spring.models.services.ICompraPagoService;
import aplicaciones.spring.models.services.IPagoDetalleService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CompraPagoRestController {

	@Autowired
	private ICompraPagoService compraPagoService;
	
	@Autowired
	private IPagoDetalleService pagoDetalleService;
	
	@GetMapping("/compras-pago")
	public List<CompraPago> index() {
		return compraPagoService.findAll();
	}
	
	@GetMapping("/compras-pago/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
	
		Map<String, Object> response = new HashMap<>();
		
		CompraPago compraPago = compraPagoService.findById(id);
		List<PagoDetalle> pagoDetalle = pagoDetalleService.findByCompraPagoId(compraPago);

		response.put("compraPago", compraPago);
		response.put("pagoDetalle", pagoDetalle);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/compras-pago")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody FormCompraPago compraPago) {
		
		Map<String, Object> response = new HashMap<>();
		
		CompraPago compraPagoNuevo = compraPagoService.save(compraPago.getCompraPago());
		
		List<PagoDetalle> pagosDetalle = compraPago.getPagoDetalle();
		List<PagoDetalle> pagosDetalleNuevo = null;
		
		if(pagosDetalle != null) {
			for(PagoDetalle pagoDetalle : pagosDetalle) {
				pagoDetalle.setCompraPagoId(compraPagoNuevo);
			}
			pagosDetalleNuevo = pagoDetalleService.savePagoDetalle(pagosDetalle);
		}
		
		response.put("compraPago", compraPagoNuevo);
		response.put("pagoDetalle", pagosDetalleNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/compras-pago/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody FormCompraPago compraPago, @PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		// Actualización para la compra pago
		CompraPago compraPagoEdit = compraPago.getCompraPago();
		CompraPago compraPagoActual = compraPagoService.findById(id);
		
		compraPagoActual.setComentarios(compraPagoEdit.getComentarios());
		compraPagoActual.setFechaComp(compraPagoEdit.getFechaComp());
		compraPagoActual.setNumComp(compraPagoEdit.getNumComp());
		compraPagoActual.setNumSerie(compraPagoEdit.getNumSerie());
		compraPagoActual.setTipoComp(compraPagoEdit.getTipoComp());
		compraPagoActual.setSaldo(compraPagoEdit.getSaldo());
		
		List<PagoDetalle> pagoDetalleEdit = compraPago.getPagoDetalle();
		List<PagoDetalle> pagoDetalleActual = pagoDetalleService.findByCompraPagoId(compraPagoActual);
		List<PagoDetalle> pagoDetalleUpdated = pagoDetalleService.updatePagoDetalle(pagoDetalleEdit, pagoDetalleActual, compraPagoActual);
		
		CompraPago compraPagoUpdated = compraPagoService.save(compraPagoActual);
		response.put("compraPago", compraPagoUpdated);
		response.put("pagoDetalle", pagoDetalleUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/compras-pago/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		CompraPago compraPago = compraPagoService.findById(id);
		pagoDetalleService.deleteByCompraPagoId(compraPago);
		compraPagoService.delete(id);
	}
	
}
