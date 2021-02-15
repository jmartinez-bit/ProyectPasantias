package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Compra;

public interface ICompraDao extends CrudRepository<Compra, Long> {

}
