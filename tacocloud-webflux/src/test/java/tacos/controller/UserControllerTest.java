package tacos.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;

class UserControllerTest {

	@Test
	void test() {
		WebTestClient testClient = WebTestClient.bindToController(new UserController()).build();
		
		testClient.get().uri("/user").exchange().expectStatus().isOk();
	}

}
