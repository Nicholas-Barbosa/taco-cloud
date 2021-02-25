package tacos.dto;

import java.time.LocalDateTime;

import tacos.domain.Taco;

public class TacoDTO {

	private LocalDateTime createdAt;

	private String name;
	
	public TacoDTO(Taco taco) {
		super();
		this.createdAt = taco.getCreatedAt();
		this.name = taco.getName();
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public String getName() {
		return name;
	}
	
	
	
}
