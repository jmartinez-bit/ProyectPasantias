package aplicaciones.spring.repository;

import org.springframework.stereotype.Repository;

import aplicaciones.spring.models.ERole;
import aplicaciones.spring.models.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
}
