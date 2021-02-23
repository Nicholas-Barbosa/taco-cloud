package tacos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.domain.Taco;
import tacos.repositry.IngredientRepository;

/*
 * Controllers sao os principais 'jogadores' do spring MVC framework.Seus
 * principal papel e lidar com requisicoes http e encaminha-las para uma view
 * para renderizar o html(browser-displayed) ou escrever dados diretamente no
 * response body(Restful).
 */

@Controller
@RequestMapping("/design")
public class DesignTacoController {

	private final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

	private final IngredientRepository ingredientRepository;

	public DesignTacoController(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}

	@GetMapping
	public String showDesignForm(Model model) {
		log.info("GetMapping for base path(/design)");
		List<Ingredient> ingredients = new ArrayList<>();
		ingredientRepository.findAll().forEach(i -> ingredients.add(i));
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		model.addAttribute("design", new Taco());
		return "design";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}

	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors) {
		if (errors.hasErrors()) {
			log.info("Has errors! " + errors.getErrorCount());
			return "redirect:/design";
		}
		log.info("Processing design " + design);
		return "redirect:/orders/current";
	}
}
