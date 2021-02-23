package tacos.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {

	/*
	 * Domain de uma aplicacao e a area de assunto que ele aborda - ideias,conceitos
	 * que influenciam o ententedimento da aplicacao.
	 * 
	 */
	@Id
	private final String id;
	private final String name;
	private final Type type;

	public Ingredient(String id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Ingredient() {
		this(null, null, null);
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
