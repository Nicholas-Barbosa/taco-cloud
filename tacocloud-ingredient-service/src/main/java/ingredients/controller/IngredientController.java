package ingredients.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import ingredients.dto.IngredientDTO;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	@GetMapping
	public Iterable<IngredientDTO> showIngredients() {
		return Arrays.asList(new IngredientDTO("chicken", IngredientDTO.Type.PROTEIN),
				new IngredientDTO("chicken2", IngredientDTO.Type.PROTEIN),
				new IngredientDTO("chicken", IngredientDTO.Type.PROTEIN));
	}

	@GetMapping("/throw-exception")
	@HystrixCommand(fallbackMethod = "showIngredientsFallBack")
	public Iterable<IngredientDTO> showIngredientsException() {

		throw new RuntimeException("Testing circuit braker!");
	}

	@GetMapping("/timeout")
	@HystrixCommand(fallbackMethod = "showIngredientsFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500") })
	public Iterable<IngredientDTO> showIngredientsTimeout() throws Exception {

		Thread.sleep(1000);
		return null;
	}

	private Iterable<IngredientDTO> showIngredientsFallBack() {
		return Arrays.asList(new IngredientDTO("falBack", IngredientDTO.Type.PROTEIN),
				new IngredientDTO("falBack2", IngredientDTO.Type.PROTEIN),
				new IngredientDTO("falBack3", IngredientDTO.Type.PROTEIN));
	}

}
