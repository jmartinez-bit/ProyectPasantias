package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Categoria;

public interface ICategoriaService {
	
	public List<Categoria> findAll();
	
	public Categoria findById(Long id);
	
	public Categoria save(Categoria categoria);
	
	public void delete(Long id);

}
