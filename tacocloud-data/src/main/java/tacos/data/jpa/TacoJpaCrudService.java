package tacos.data.jpa;

import java.util.Optional;

import org.springframework.stereotype.Service;

import tacos.data.TacoCrudService;
import tacos.domain.Taco;
import tacos.repositry.jpa.TacoJpaRepository;

@Service
public class TacoJpaCrudService implements TacoCrudService {

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
