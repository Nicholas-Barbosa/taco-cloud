package tacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.service.GreetingProperties;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	private final GreetingProperties greetingProperties;

	public GreetingController(GreetingProperties greetingProperties) {
		super();
		this.greetingProperties = greetingProperties;
	}

	@GetMapping("/hello")
	public String sayHello() {
		return greetingProperties.getMessage();
	}
}
