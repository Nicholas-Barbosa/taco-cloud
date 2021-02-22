package tacos.domain;

import java.util.ArrayList;
import java.util.List;

public class Taco {

	private String name;
	private List<String> ingredients;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = new ArrayList<>(ingredients);
	}

	@Override
	public String toString() {
		return "Taco [name=" + name + ", ingredients=" + ingredients + "]";
	}

}
