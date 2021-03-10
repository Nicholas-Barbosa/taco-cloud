package tacos.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IngredientService {

	private final RestTemplate restTemplate;

	public IngredientService(@LoadBalanced RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public Object[] getIngredientsFromMcSerivce() {
		return restTemplate.getForObject("http://ingredient-service/ingredients", Object[].class);
	}
}
