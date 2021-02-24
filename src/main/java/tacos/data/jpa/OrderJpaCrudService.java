package tacos.data.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import tacos.data.OrderCrudService;
import tacos.domain.Order;
import tacos.domain.User;
import tacos.repositry.jpa.OrderJpaRepository;

public class OrderJpaCrudService implements OrderCrudService {

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

	@Override
	public List<Order> findByUser(User user, Pageable page) {
		// TODO Auto-generated method stub
		return orderJpaRepo.findByUserOrderByPlacedAtDesc(user, page);
	}

}
