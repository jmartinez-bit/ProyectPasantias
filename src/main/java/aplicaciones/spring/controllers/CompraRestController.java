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

import aplicaciones.spring.models.Compra;
import aplicaciones.spring.models.Direccion;
import aplicaciones.spring.models.FormCompra;
import aplicaciones.spring.models.PersonaContacto;
import aplicaciones.spring.models.ProductoCompra;
import aplicaciones.spring.models.Proveedor;
import aplicaciones.spring.models.services.ICompraService;
import aplicaciones.spring.models.services.IDireccionService;
import aplicaciones.spring.models.services.IPersonaContactoService;
import aplicaciones.spring.models.services.IProductoCompraService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CompraRestController {
	
	@Autowired
	private ICompraService compraService;
	
	@Autowired
	private IDireccionService direccionService;
	
	@Autowired
	private IPersonaContactoService personaContactoService;
	
	@Autowired
	private IProductoCompraService productoCompraService;
	
	@GetMapping("/compras")
	public List<Compra> index() {
		return compraService.findAll();
	}
	
	@GetMapping("/compras/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		Compra compra = compraService.findById(id);
		List<Direccion> direcciones = direccionService.findByProveedorId(compra.getProveedorId());
		List<PersonaContacto> personas = personaContactoService.findByProveedorId(compra.getProveedorId());
		List<ProductoCompra> productosCompra = productoCompraService.findByCompraId(compra);
		
		response.put("compra", compra);
		response.put("direccion", direcciones);
		response.put("personaContacto", personas);
		response.put("productoCompra", productosCompra);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/compras")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody FormCompra compra) {
		
		Map<String, Object> response = new HashMap<>();
		
		Compra compraNueva = compraService.save(compra.getCompra());
		
		List<ProductoCompra> productos = compra.getProductoCompra();
		List<ProductoCompra> productosNuevos = null;
		if(productos != null) {
			for(ProductoCompra producto : productos) {
				producto.setCompraId(compraNueva);
			}
			productosNuevos = productoCompraService.saveProductos(productos);
		}
		
		response.put("compra", compraNueva);
		response.put("productoCompra", productosNuevos);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/compras/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody FormCompra compra, @PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		// Actualización para compra
		Compra compraEdit = compra.getCompra();
		Compra compraActual = compraService.findById(id);
		
		compraActual.setCodigo(compraEdit.getCodigo());
		compraActual.setComentarios(compraEdit.getComentarios());
		compraActual.setCotizacion(compraEdit.getCotizacion());
		compraActual.setDoc(compraEdit.getDoc());
		compraActual.setEstado(compraEdit.getEstado());
		compraActual.setFechaOrden(compraEdit.getFechaOrden());
		compraActual.setFechaVenc(compraEdit.getFechaVenc());
		compraActual.setMoneda(compraEdit.getMoneda());
		compraActual.setOrdenCompra(compraEdit.getOrdenCompra());
		compraActual.setPersonaContactoId(compraEdit.getPersonaContactoId());
		compraActual.setProveedorId(compraEdit.getProveedorId());
		compraActual.setTipoCompra(compraEdit.getTipoCompra());
		compraActual.setTotalComprobante(compraEdit.getTotalComprobante());
		
		List<ProductoCompra> productoCompraEdit = compra.getProductoCompra();
		List<ProductoCompra> productoCompraActual = productoCompraService.findByCompraId(compraActual);
		List<ProductoCompra> productoCompraUpdated = productoCompraService.updateProductoCompra(productoCompraEdit, productoCompraActual, compraActual);
		
		Compra compraUpdated = compraService.save(compraActual);
		
		response.put("compra", compraUpdated);
		response.put("productoCompra", productoCompraUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/compras/{id}")
	public void delete(@PathVariable Long id) {
		Compra compra = compraService.findById(id);
		productoCompraService.deleteByCompraId(compra);
		compraService.delete(id);
	}
	
}
