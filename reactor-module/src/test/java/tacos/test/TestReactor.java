package tacos.test;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

class TestReactor {

	@Test
	void test() {
		Flux<String> publisher = Flux.just("n", "i");
		publisher.map(x -> {
			System.out.println("x " + x);
			return x;
		}).subscribe(System.out::println);

		System.out.println("---Java Stream---");
		Stream<String> stream = Stream.of("n", "i");
		stream.map(x -> {
			System.out.println("x " + x);
			return x;
		}).forEach(System.out::println);
	}

}
