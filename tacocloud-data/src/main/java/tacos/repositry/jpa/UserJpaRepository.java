package tacos.repositry.jpa;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tacos.domain.User;

public interface UserJpaRepository extends CrudRepository<User, Long> {

	Optional<User>getByUsername(String username);
	
}
