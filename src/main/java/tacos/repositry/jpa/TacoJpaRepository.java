package tacos.repositry.jpa;

import org.springframework.data.repository.CrudRepository;

import tacos.domain.Taco;

public interface TacoJpaRepository extends CrudRepository<Taco, Long> {

}
