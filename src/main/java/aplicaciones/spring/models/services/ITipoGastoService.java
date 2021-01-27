package aplicaciones.spring.models.services;

import java.util.List;

import aplicaciones.spring.models.TipoGasto;

public interface ITipoGastoService {
	
	public List<TipoGasto> findAll();
	
	public TipoGasto findById(Long id);
	
	public TipoGasto save(TipoGasto tipoGasto);
	
	public void delete(Long id);

}
