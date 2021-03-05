package tacos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import tacos.dto.UserForm;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public Mono<String> showUser() {
		return Mono.just("Nicholas");
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<UserForm> processUser(@RequestBody Mono<UserForm> userForm) {
		System.out.println("method");
		return userForm;
	}

	@PostMapping("/non")
	@ResponseStatus(HttpStatus.CREATED)
	public String processUserNon(@RequestBody UserForm userForm) {
		System.out.println("method non");
		return "created";
	}
}
