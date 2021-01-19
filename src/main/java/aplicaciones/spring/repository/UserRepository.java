package aplicaciones.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	/*List<User> findAllUsers(String username);*/
}
