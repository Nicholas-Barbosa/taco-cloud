package tacos.data.jpa;

import java.util.Optional;

import tacos.data.CrudService;
import tacos.domain.Taco;
import tacos.repositry.jpa.TacoJpaRepository;

public class TacoJpaCrudService implements CrudService<Taco, Long> {

	private final TacoJpaRepository tacoJpaRepo;

	public TacoJpaCrudService(TacoJpaRepository tacoJpaRepo) {
		super();
		this.tacoJpaRepo = tacoJpaRepo;
	}

	@Override
	public Taco save(Taco t) {
		// TODO Auto-generated method stub
		return tacoJpaRepo.save(t);
	}

	@Override
	public Iterable<Taco> findAll() {
		// TODO Auto-generated method stub
		return tacoJpaRepo.findAll();
	}

	@Override
	public Optional<Taco> findById(Long id) {
		// TODO Auto-generated method stub
		return tacoJpaRepo.findById(id);
	}

}
