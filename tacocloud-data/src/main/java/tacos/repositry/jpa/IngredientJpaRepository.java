package tacos.repositry.jpa;

import org.springframework.data.repository.CrudRepository;

import tacos.domain.Ingredient;

public interface IngredientJpaRepository extends CrudRepository<Ingredient, String>{

}
