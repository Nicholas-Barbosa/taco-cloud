package tacos.data.jdbc;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import tacos.domain.Order;
import tacos.domain.Taco;
import tacos.repositry.jdbc.OrderRepository;

@Repository
public class JdbcOrderRepository implements OrderRepository {

	private final SimpleJdbcInsert orderInserter;
	private final SimpleJdbcInsert orderTacoInserter;
	private final ObjectMapper objectMapper;

	public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.orderInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Taco_Order")
				.usingGeneratedKeyColumns("id");
		this.orderTacoInserter = new SimpleJdbcInsert(jdbcTemplate).withTableName("Taco_Order_Tacos");
		this.objectMapper = new ObjectMapper();
	}

	@Override
	public Order save(Order order) {
		order.setPlacedAt(LocalDateTime.now());
		long orderId = saveOrderDetails(order);
		order.setId(orderId);
		List<Taco> tacos = order.getTacos();
		for (Taco taco : tacos) {
			saveTacoToOrder(taco, orderId);
		}
		return order;
	}

	private long saveOrderDetails(Order order) {
		@SuppressWarnings("unchecked")
		Map<String, Object> values = objectMapper.convertValue(order, Map.class);
		values.put("placedAt", order.getPlacedAt());

		long orderId = orderInserter.executeAndReturnKey(values).longValue();
		return orderId;
	}

	private void saveTacoToOrder(Taco taco, long orderId) {
		Map<String, Object> values = new HashMap<>();
		values.put("tacoOrder", orderId);
		values.put("taco", taco.getId());
		orderTacoInserter.execute(values);
	}
}
