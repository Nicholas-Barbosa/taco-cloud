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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.repositry.jdbc.IngredientRepository;
import tacos.repositry.jdbc.TacoRepository;
import tacos.domain.Order;
import tacos.domain.Taco;

/*
 * Controllers sao os principais 'jogadores' do spring MVC framework.Seus
 * principal papel e lidar com requisicoes http e encaminha-las para uma view
 * para renderizar o html(browser-displayed) ou escrever dados diretamente no
 * response body(Restful).
 */

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

	private final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

	private final IngredientRepository ingredientRepository;

	private final TacoRepository designRepo;

	public DesignTacoController(IngredientRepository ingredientRepository, TacoRepository tacoRepo) {
		super();
		this.ingredientRepository = ingredientRepository;
		this.designRepo = tacoRepo;
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

	@ModelAttribute("order")
	public Order order() {
		return new Order();
	}

	@ModelAttribute("taco")
	public Taco taco() {
		return new Taco();
	}


	@PostMapping
	public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
		if (errors.hasErrors()) {
			log.info("Has errors! " + errors.getFieldError("name"));
			return "/design";
		}
		log.info("Processing design " + design);

		Taco saved = designRepo.save(design);
		order.addDesign(saved);
		return "redirect:/orders/current";
	}

	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}
}
