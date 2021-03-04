package tacos.test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

class TestReactor {

//	@Test
//	void test() {
//
//		Flux<String> publisher = Flux.just("n", "i");
//		publisher.map(x -> {
//			System.out.println("x " + x);
//			return x;
//		}).subscribe(System.out::println);
//
//		System.out.println("---Java Stream---");
//		Stream<String> stream = Stream.of("n", "i");
//		stream.map(x -> {
//			System.out.println("x " + x);
//			return x;
//		}).forEach(System.out::println);
//	}
//
//	@Test
//	void createFluxFromArray() {
//		Flux<String> flux = Flux.fromArray(new String[] { "Apple", "Banana" });
//		Assert.assertEquals(2, flux.count().block().longValue());
//	}
//
//	@Test
//	void createFluxFromIterable() {
//		Flux<String> flux = Flux.fromIterable(List.of("Apple", "Banana"));
//		Assert.assertEquals(2, flux.count().block().longValue());
//	}
//
//	@Test
//	void createFluxFromStream() {
//		Flux<String> flux = Flux.fromStream(Stream.of("Apple", "Banana"));
//		Assert.assertEquals(2, flux.count().block().longValue());
//	}
//
//	@Test
//	void generatingFlux() {
//		Flux<Integer> flux = Flux.range(0, 101);
//		Assert.assertEquals(101, flux.count().block().longValue());
//	}
//
//	@Test
//	void intervalFlux() {
//		Flux<Long> flux = Flux.interval(Duration.ofSeconds(1)).take(5);
//		Assert.assertEquals(5, flux.count().block().longValue());
//	}
//
//	@Test
//	void mergeFlux() {
//		System.out.println("---merging---");
//
//		Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa");
//		Flux<String> foodFlux = Flux.just("Lasagna", "Lollipops", "Apples");
//
//		characterFlux.mergeWith(foodFlux).subscribe(System.out::println);
//		System.out.println("---end merging---");
//	}
//
//	@Test
//	void tuple() {
//		System.out.println("---zipping---");
//		/*
//		 * Reduction para pares de elementos de fontes diferentes.
//		 */
//		Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa");
//		Flux<String> foodFlux = Flux.just("Lasagna", "Lollipops", "Apples");
//
//		Flux.zip(characterFlux, foodFlux, (c, f) -> c + " eat " + f).subscribe(System.out::println);
//		System.out.println("---end zipping---");
//	}
//
//	@Test
//	void first() {
//		System.out.println("---first---");
//		/*
//		 * Reduction para pares de elementos de fontes diferentes.
//		 */
//		Flux<String> characterFlux = Flux.just("Garfield", "Kojak", "Barbossa")
//				.delaySubscription(Duration.ofMillis(250));
//		Flux<String> foodFlux = Flux.just("Lasagna", "Lollipops", "Apples");
//
//		StepVerifier.create(Flux.firstWithSignal(characterFlux, foodFlux)).expectNext("Lasagna").expectNext("Lollipops")
//				.expectNext("Apples").verifyComplete();
//		System.out.println("---end first---");
//
//	}
//
//	@Test
//	void skipAFewSeconds() {
//		Flux<String> fluxToSkip = Flux.just("a", "b", "c", "d", "s");
//		StepVerifier.create(fluxToSkip.delayElements(Duration.ofSeconds(1)).skip(Duration.ofSeconds(4)))
//				.expectNext("d", "s").verifyComplete();
//	}
//
//	@Test
//	void testeTake() {
//		Flux<String> fluxToSkip = Flux.just("a", "b", "c", "d", "s");
//		StepVerifier.create(fluxToSkip.take(3)).expectNext("a", "b", "c").expectComplete();
//
//		StepVerifier.create(fluxToSkip.delayElements(Duration.ofSeconds(1)).take(Duration.ofMillis(1200)))
//				.expectNext("a").verifyComplete();
//		
//		StepVerifier.create(fluxToSkip.delaySubscription(Duration.ofSeconds(1)).take(Duration.ofMillis(1200)))
//		.expectNext("a","b", "c", "d", "s").verifyComplete();
//	}
//
//	@Test
//	void testFilter() {
//		Flux<Integer> fluxToSkip = Flux.range(0, 1000);
//		StepVerifier.create(fluxToSkip.filter(x -> x <= 5)).expectNext(0, 1, 2, 3, 4, 5).verifyComplete();
//	}
	
	@Test
	void testFlatMap() {
		Flux<Integer> flux = Flux.just(1, 2, 3);
		flux. flatMap(x -> {
			try {
				System.out.println("Nicholas Thread from pReactor sleeping...");
				Thread.sleep(1000);
				System.out.println("Nicholas Thread from pReactor woke up!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Mono.just(x * 10);
		}).subscribeOn(Schedulers.parallel()).subscribe();

	}

	@Test
	void testStreamFlatMap() {
		Stream.of(1, 2, 3).parallel().flatMap(x -> {
			try {
				System.out.println("Nicholas Thread from Stream API sleeping...");
				Thread.sleep(1000);
				System.out.println("Nicholas Thread from Stream API woke up!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Stream.of(x * 10);
		}).collect(Collectors.counting());
	}
}
