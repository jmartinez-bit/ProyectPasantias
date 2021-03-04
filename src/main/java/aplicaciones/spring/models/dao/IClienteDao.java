package aplicaciones.spring.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import aplicaciones.spring.models.Cliente;

public interface IClienteDao extends PagingAndSortingRepository<Cliente, Long>{

	public Page<Cliente> findAll(Pageable pageable);
	
	Cliente findTopByOrderByIdDesc();
	
}
