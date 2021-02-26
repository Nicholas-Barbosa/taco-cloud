package tacos.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import tacos.data.UserCrudService;
import tacos.domain.User;

@Configuration
@Profile("dev")
public class DataLoaderDevPf implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(DataLoaderDevPf.class);
	private final UserCrudService userCrudService;

	public DataLoaderDevPf(UserCrudService userCrudService) {
		super();
		this.userCrudService = userCrudService;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Bootstraping User Object...");
		for (int i = 0; i < 100; i++) {
			userCrudService.save(new User("nicholas"+i, "$2a$10$aIbd.c2hP6nMp8qlOilIlegl4cfOyMzHf3dLhMa1Oq5F2QI5wIKCe"));
		}
		log.info("User Object saved!");
	}

}
