package tacos.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.beans.HelloService;

@RestController
@RequestMapping("change")
public class ChangeMessageResource {

	private final HelloService helloService;

	public ChangeMessageResource(HelloService helloService) {
		super();
		System.out.println("HelloService");
		this.helloService = helloService;
	}

	@GetMapping
	public String sayHello() {
		helloService.setMessage("Passei no java!78%");
		return helloService.sayHello();
	}
}
