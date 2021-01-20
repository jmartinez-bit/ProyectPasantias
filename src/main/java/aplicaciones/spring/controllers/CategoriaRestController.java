package aplicaciones.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aplicaciones.spring.models.Categoria;
import aplicaciones.spring.models.services.ICategoriaService;

@RestController
@RequestMapping("/api")
public class CategoriaRestController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@GetMapping("/categorias")
	public List<Categoria> categorias() {
		return categoriaService.findAll();
	}
}
