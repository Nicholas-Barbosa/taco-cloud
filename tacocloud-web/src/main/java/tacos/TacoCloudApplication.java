package tacos;

import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TacoCloudApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TacoCloudApplication.class, args);
		System.out.println(ctx.getBean(Upcase.class).upcase(List.of("ni", "i", "c", "h", "o", "l", "a", "s")));
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("login");
	}

	@MessagingGateway
	public interface Upcase {

		@Gateway(requestChannel = "upcase.input")
		Collection<String> upcase(Collection<String> strings);

	}

	@Bean
	public IntegrationFlow upcase() {
		return f -> f.split().<String>filter(p -> {
			p = "n";
			return p.equals("n");
		}) // 1
				.<String, String>transform(String::toUpperCase) // 2
				.aggregate(); // 3
	}
}
