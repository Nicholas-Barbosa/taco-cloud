package tacos.repositry.jpa;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import tacos.domain.Order;
import tacos.domain.User;

public interface OrderJpaRepository extends CrudRepository<Order, Long> {

	List<Order> findByUserOrderByPlacedAtDesc(User user,Pageable page);
}
