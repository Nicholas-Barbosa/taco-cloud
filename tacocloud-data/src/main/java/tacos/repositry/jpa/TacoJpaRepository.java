package tacos.repositry.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import tacos.domain.Taco;

public interface TacoJpaRepository extends PagingAndSortingRepository<Taco, Long> {

}
