package ingredients.dto;

public class IngredientDTO {

	private String name;
	private Type type;

	
	public IngredientDTO(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE;
	}
}
