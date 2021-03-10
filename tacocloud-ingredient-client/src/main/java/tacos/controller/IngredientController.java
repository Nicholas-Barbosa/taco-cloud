package tacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.service.IngredientFeignCLient;
import tacos.service.IngredientService;

@RestController
@RequestMapping("/ingredients-client")
public class IngredientController {

	private final IngredientService ingredientService;

	private final IngredientFeignCLient ingredientFeignCLient;

	public IngredientController(IngredientService ingredientService, IngredientFeignCLient ingredientFeignCLient) {
		super();
		this.ingredientService = ingredientService;
		this.ingredientFeignCLient = ingredientFeignCLient;
	}

	@GetMapping
	public Object[] showIngredientsFromMcService() {
		return ingredientService.getIngredientsFromMcSerivce();
	}

	@GetMapping("/feign")
	public Object[] showIngredientsFromMcServiceUsingFeign() {
		return ingredientFeignCLient.getIngredients();
	}
}
