package tacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.service.IngredientService;

@RestController
@RequestMapping("/ingredients-client")
public class IngredientController {

	private final IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {
		super();
		this.ingredientService = ingredientService;
	}

	@GetMapping
	public Object[] showIngredientsFromMcService() {
		return ingredientService.getIngredientsFromMcSerivce();
	}
}
