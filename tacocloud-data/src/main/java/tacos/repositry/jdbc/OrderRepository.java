package tacos.repositry.jdbc;

import tacos.domain.Order;

public interface OrderRepository {

	Order save(Order order);
}
