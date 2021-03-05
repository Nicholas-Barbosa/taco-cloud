package tacos.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;
import tacos.dto.UserForm;

class UserControllerTest {

	private final WebTestClient testClient = WebTestClient.bindToController(new UserController()).build();
	
	@Test
	void test() {
		testClient.get().uri("/user").exchange().expectStatus().isOk();
	}
	@Test
	void testUsersEnpoints() {
		testClient.get().uri("user/s").exchange().expectBodyList(Integer.class);
	}
	
	@Test
	void testPost() {
		Mono<UserForm>monoUser = Mono.just(new UserForm());
		
		testClient.post().uri("/user").contentType(MediaType.APPLICATION_JSON).body(monoUser,UserForm.class).exchange().expectStatus().isCreated();
		
	}
}
