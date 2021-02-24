package tacos.configuration.profiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class BeanWiringDevelopmentProfile {

	@Bean
	public CommandLineRunner dataLader() {
		System.out.println("CommandLineRunner injected in container by DevelopmentProfile config class");
		return null;
	}
}
