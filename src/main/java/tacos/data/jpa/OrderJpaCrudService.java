package tacos.data.jpa;

import java.util.Optional;

import tacos.data.CrudService;
import tacos.domain.Order;
import tacos.repositry.jpa.OrderJpaRepository;

public class OrderJpaCrudService implements CrudService<Order, Long> {

	private final OrderJpaRepository orderJpaRepo;

	public OrderJpaCrudService(OrderJpaRepository orderJpaRepo) {
		super();
		this.orderJpaRepo = orderJpaRepo;
	}

	@Override
	public Order save(Order t) {
		// TODO Auto-generated method stub
		return orderJpaRepo.save(t);
	}

	@Override
	public Iterable<Order> findAll() {
		// TODO Auto-generated method stub
		return orderJpaRepo.findAll();
	}

	@Override
	public Optional<Order> findById(Long id) {
		// TODO Auto-generated method stub
		return orderJpaRepo.findById(id);
	}

}
