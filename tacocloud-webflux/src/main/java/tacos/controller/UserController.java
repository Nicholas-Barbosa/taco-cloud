package tacos.controller;

import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tacos.dto.UserForm;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public Mono<String> showUser() {
		return Mono.just("Nicholas");
	}

	@GetMapping("/timeout")
	public Mono<String> showUserTimeout() throws InterruptedException {
		Thread.sleep(1500);
		return Mono.just("Nicholas");
	}

	@GetMapping("/not-found")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Mono<String> showUserNotFound() {
		return Mono.just("Nicholas");
	}

	@GetMapping("/s")
	public Flux<Integer> showUsers() {
		return Flux.fromStream(Stream.iterate(1, v -> v <= 100, e -> ++e));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<UserForm> processUser(@RequestBody Mono<UserForm> userForm) {
		System.out.println("method");
		return userForm;
	}

	@PostMapping("/non")
	@ResponseStatus(HttpStatus.CREATED)
	public String processUserNon(@RequestBody UserForm userForm) throws InterruptedException {
		System.out.println("method non");
		Thread.sleep(1000);
		return "created";
	}
}
