package tacos.repositry.jpa;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import tacos.domain.User;

public interface UserJpaRepository extends PagingAndSortingRepository<User, Long> {

	Optional<User> getByUsername(String username);

}
