package tacos.webclient;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tacos.ObjectNotFoundException;
import tacos.dto.UserForm;

@SpringBootTest

class WebClientConfigTest {

	@Autowired
	private WebClient webClient;

	@Test
	void test() throws InterruptedException {
		webClient.get().uri("/user").retrieve().bodyToMono(String.class).subscribe(x -> System.out.println(x));
		Thread.sleep(200);

	}

	@Test
	void testTimeout() throws InterruptedException {

		webClient.get().uri("/user/timeout").retrieve().bodyToMono(String.class).timeout(Duration.ofSeconds(10))
				.subscribe(x -> System.out.println(x));
		Thread.sleep(1600);

	}

	@Test
	void post() {
		webClient.post().uri("/user").bodyValue(new UserForm("Nicholas")).retrieve().bodyToMono(String.class)
				.subscribe(System.out::println);
	}

	@Test
	void getNotFound() {
		webClient.get().uri("/user/not-found").retrieve().onStatus(WebClientConfigTest::isNotFound, reposnse -> Mono.just(new ObjectNotFoundException())).bodyToMono(String.class)
				.subscribe(System.out::println);
	}

	private static boolean isNotFound(HttpStatus http) {
		return http == HttpStatus.NOT_FOUND;
	}
}
