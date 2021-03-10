package ingredients.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
