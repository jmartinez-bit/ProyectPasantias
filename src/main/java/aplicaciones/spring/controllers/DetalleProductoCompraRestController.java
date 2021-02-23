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

import aplicaciones.spring.models.DetalleProductoCompra;
import aplicaciones.spring.models.FormDetalleProductoCompra;
import aplicaciones.spring.models.ProductoCompra;
import aplicaciones.spring.models.services.IDetalleProductoCompraService;
import aplicaciones.spring.models.services.IProductoCompraService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class DetalleProductoCompraRestController {

	@Autowired
	private IDetalleProductoCompraService detalleProductoCompraService;
	
	@Autowired
	private IProductoCompraService productoCompraService;
	
	@GetMapping("/detalles-producto")
	public List<DetalleProductoCompra> index() {
		return detalleProductoCompraService.findAll();
	}
	
	@GetMapping("/detalles-producto/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		ProductoCompra productoCompra = productoCompraService.findById(id);
		
		List<DetalleProductoCompra> detalles = detalleProductoCompraService.findByProductoCompra(productoCompra);
		
		response.put("detalleProductoCompra", detalles);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/detalles-producto/{id}/save")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create (@RequestBody FormDetalleProductoCompra detalleProductoCompra, @PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		ProductoCompra productoCompra = productoCompraService.findById(id);
		
		List<DetalleProductoCompra> detalles = detalleProductoCompra.getDetalleProductoCompra();
		List<DetalleProductoCompra> detallesNuevo = null;
		if(detalles != null) {
			for(DetalleProductoCompra detalle : detalles) {
				detalle.setProductoCompraId(productoCompra);
			}
			detallesNuevo = detalleProductoCompraService.saveDetalleCompra(detalles);
		}
		
		response.put("detalleProductoCompra", detallesNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/detalles-producto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody FormDetalleProductoCompra detalleProductoCompra, @PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		ProductoCompra productoCompra = productoCompraService.findById(id);
		
		// Actualización para DetalleProductoCompra
		List<DetalleProductoCompra> detalleEdit = detalleProductoCompra.getDetalleProductoCompra();
		List<DetalleProductoCompra> detalleActual = detalleProductoCompraService.findByProductoCompra(productoCompra);
		List<DetalleProductoCompra> detalleUpdated = detalleProductoCompraService.updateDetalleCompra(detalleEdit, detalleActual);
		
		response.put("detalleProductoCompra", detalleUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
