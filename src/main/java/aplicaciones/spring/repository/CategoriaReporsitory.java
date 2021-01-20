package aplicaciones.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.models.Categoria;

@Repository
public interface CategoriaReporsitory extends JpaRepository<Categoria, Long>{

}
