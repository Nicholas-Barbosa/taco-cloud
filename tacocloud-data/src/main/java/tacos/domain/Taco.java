package tacos.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@RestResource(path = "tacos", rel = "tacos")
public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private LocalDateTime createdAt;

	@NotNull
	@Size(min = 5, message = "Name must be at least 5 characteres.")
	private String name;

	@NotNull
	@Size(min = 1, message = "You must choose at least 1 ingredient")
	@ManyToMany
	@JoinTable(name = "TACO_INGREDIENTS", joinColumns = @JoinColumn(name = "TACO_ID"), inverseJoinColumns = @JoinColumn(name = "INGREDIENTS_ID"))
	private List<Ingredient> ingredients;

	@PrePersist
	void createdAt() {
		createdAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

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
		this.ingredients = new ArrayList<>(ingredients);
	}

	@Override
	public String toString() {
		return "Taco [name=" + name + ", ingredients=" + ingredients + "]";
	}

}
