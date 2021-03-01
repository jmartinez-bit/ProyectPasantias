package aplicaciones.spring.models.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import aplicaciones.spring.models.Banco;

public interface IBancoDao extends PagingAndSortingRepository<Banco, Long>{

	public Page<Banco> findAll(Pageable pageable);
	
}
