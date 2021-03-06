package aplicaciones.spring.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aplicaciones.spring.models.Banco;

public interface IBancoService {

	public Page<Banco> findAll(Pageable pageable);
	
	public Banco findById(Long id);
	
	public Banco save(Banco banco);
	
	public void delete(Long id);
	
	public List<Banco> findAllBancos();
	
}
