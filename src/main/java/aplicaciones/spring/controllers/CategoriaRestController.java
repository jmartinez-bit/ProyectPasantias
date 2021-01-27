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

import aplicaciones.spring.models.Categoria;
import aplicaciones.spring.models.services.ICategoriaService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CategoriaRestController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List<Categoria> categorias() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria show(@PathVariable Long id) {
		return categoriaService.findById(id);
	}
	
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria create(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}
	
	@PutMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria update(@RequestBody Categoria categoria, @PathVariable Long id) {
		Categoria categoriaActual = categoriaService.findById(id);
		
		categoriaActual = categoriaService.findById(id);
		
		categoriaActual.setDescripcion(categoria.getDescripcion());
		categoriaActual.setNombre(categoria.getNombre());
		categoriaActual.setParent(categoria.getParent());
		
		return categoriaService.save(categoriaActual);
	}
	
	@DeleteMapping("/categorias/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		categoriaService.delete(id);
	}
}
