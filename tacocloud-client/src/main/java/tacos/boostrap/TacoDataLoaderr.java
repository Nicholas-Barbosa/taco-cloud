package tacos.boostrap;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import tacos.dto.UserDTO;

@Component
public class TacoDataLoaderr implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(TacoDataLoaderr.class);
	
	private final RestTemplate restTemplate;

	public TacoDataLoaderr(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Getting Response object for GET: /users/no-links...");
		ResponseEntity<UserDTO[]> response = restTemplate.getForEntity("http://localhost/api/datarest/users/no-links",
				UserDTO[].class);
		log.info("Got status: " +response.getStatusCodeValue() +"  body: " + Arrays.toString(response.getBody()));
	}

}
