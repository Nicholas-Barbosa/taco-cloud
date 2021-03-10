package tacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ingredient-service")
public interface IngredientFeignCLient {

	@GetMapping("/ingredients")
	Object[] getIngredients();
}
