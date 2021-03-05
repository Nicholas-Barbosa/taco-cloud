package tacos.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

class ParallelStreamsTest {

	

	@Test
	void test() throws InterruptedException {
		Flux<Integer> flux = Flux.just(1, 2, 3);
		flux.parallel().runOn(Schedulers.parallel()).log().map(x -> {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return x * 10;
		}).subscribe(x -> {
			System.out.println("Element " + x);
		});

	}

	@Test
	void testStream() throws InterruptedException {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		ExecutorService executor = null;
		try {
			executor = Executors.newCachedThreadPool();
			executor.execute(() -> {
				stream.parallel().map(x -> {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return x * 10;
				}).map(x -> {
					System.out.println("Element " + x);
					return x;
				}).collect(Collectors.counting());
			});
		}finally {
			executor.shutdown();
		}
		

	}
}
