package tacos.configuration.profiles;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class BeanWiringProductionProfile {

	@Bean
	public CommandLineRunner dataLader() {
		System.out.println("CommandLineRunner injected in container by ProductionProfile config class");
		return null;
	}
}
