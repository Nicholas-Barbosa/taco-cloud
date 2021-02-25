package tacos.data.jpa;

import java.util.Optional;

import tacos.data.CrudService;
import tacos.domain.Ingredient;
import tacos.repositry.jpa.IngredientJpaRepository;

public class IngredientJpaCrudService implements CrudService<Ingredient, String> {

	private final IngredientJpaRepository inJpaRepo;

	public IngredientJpaCrudService(IngredientJpaRepository inJpaRepo) {
		super();
		this.inJpaRepo = inJpaRepo;
	}

	@Override
	public Ingredient save(Ingredient t) {
		// TODO Auto-generated method stub
		return inJpaRepo.save(t);
	}

	@Override
	public Iterable<Ingredient> findAll() {
		// TODO Auto-generated method stub
		return inJpaRepo.findAll();
	}

	@Override
	public Optional<Ingredient> findById(String id) {
		// TODO Auto-generated method stub
		return inJpaRepo.findById(id);
	}

}
