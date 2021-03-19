package tacos.resources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thread")
public class ThreadResource {

	@GetMapping
	public String processThread() {
		createAndExecuteThreadTask();
		return "thread descouple";
	}

	private void createAndExecuteThreadTask() {
		ExecutorService executor = null;
		try {
			executor = Executors.newFixedThreadPool(2);
			executor.submit(() -> System.out.println("submited task1"));
			executor.submit(() -> System.out.println("submited task2"));
		} finally {
			// executor.shutdown();
		}
	}
}
