package tacos.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import tacos.domain.Ingredient;

public class TacoForm {


	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characteres.")
	private String name;

	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	
	private List<Ingredient> ingredients;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
