package aplicaciones.spring.models.dao;

import org.springframework.data.repository.CrudRepository;

import aplicaciones.spring.models.Categoria;

public interface ICategoriaDao extends CrudRepository<Categoria, Long> {

}
