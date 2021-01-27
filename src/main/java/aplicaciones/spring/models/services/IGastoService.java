package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.Gasto;

public interface IGastoService {
	
	public List<Gasto> findAll();
	
	public Gasto findById(Long id);
	
	public Gasto save(Gasto gasto);
	
	public void delete(Long id);

}
