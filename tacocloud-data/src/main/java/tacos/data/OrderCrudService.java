package tacos.data;

import java.util.List;

import org.springframework.data.domain.Pageable;

import tacos.domain.Order;
import tacos.domain.User;

public interface OrderCrudService extends CrudService<Order, Long> {

	List<Order> findByUser(User user,Pageable page);
}
