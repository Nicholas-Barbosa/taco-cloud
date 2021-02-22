package tacos.domain;

public class Ingredient {

	/*
	 * Domain de uma aplicacao e a area de assunto que ele aborda - ideias,conceitos
	 * que influenciam o ententedimento da aplicacao.
	 * 
	 */
	private final String id;
	private final String name;
	private final Type type;

	public Ingredient(String id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public static enum Type {
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}
}
