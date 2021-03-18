package tacos.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.beans.HelloService;

@RestController
public class HelloResource {

	private final HelloService helloService;

	public HelloResource(HelloService helloService) {
		super();
		System.out.println("HelloService");
		this.helloService = helloService;
	}

	@GetMapping
	public String sayHello() {
		return helloService.sayHello();
	}

}
