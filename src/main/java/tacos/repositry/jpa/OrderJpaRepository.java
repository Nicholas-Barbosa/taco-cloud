package tacos.repositry.jpa;

import org.springframework.data.repository.CrudRepository;

import tacos.domain.Order;

public interface OrderJpaRepository extends CrudRepository<Order, Long> {

}
