package tacos.boostrap;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import tacos.dto.UserDTO;
import tacos.dto.UserPostForm;

@Component
public class TacoDataLoaderr implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(TacoDataLoaderr.class);

	private final RestTemplate restTemplate;

	private final String controllerBasePath = "http://localhost/api/datarest/users/";

	public TacoDataLoaderr(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		performHttpGet();
		performHttpPut();
		performHttpPost();
		performHttpGetWithSpringTraversonApi();
	}

	private void performHttpGet() {
		log.info("Getting Response object for GET: /users/no-links...");
		ResponseEntity<UserDTO[]> response = restTemplate.getForEntity("http://localhost/api/datarest/users/no-links",
				UserDTO[].class);
		log.info(response.getHeaders().getDate() + "");
		log.info("Got status: " + response.getStatusCodeValue() + "  body: " + Arrays.toString(response.getBody()));
	}

	private void performHttpPut() {
		log.info("Performing HTTP Put request for PUT: /users");
		UserDTO userDto = new UserDTO("nicholas", "Nicholas Henrique Barbosa Oliveira", "xxx", "yyy");

		restTemplate.put(controllerBasePath.concat("/{id}"), userDto, 1);
		log.info("Got for HTTP Put request for PUT: /users");
	}

	private void performHttpPost() {
		log.info("Performing HTTP Post request for POST: /users");
		UserPostForm requestObject = new UserPostForm("nk1", "321", "Nicholas Henrique Barbosa Oliveira", "xxx", "yyy");

		ResponseEntity<UserPostForm> response = restTemplate.postForEntity(controllerBasePath, requestObject,
				UserPostForm.class);

		System.out.println(response.getBody());
		log.info("Got for HTTP Post request for Post: /users");
	}

	private void performHttpGetWithSpringTraversonApi() {
		Traverson traverson = new Traverson(URI.create(controllerBasePath), MediaTypes.HAL_JSON);

		ParameterizedTypeReference<CollectionModel<UserDTO>> userType = new ParameterizedTypeReference<CollectionModel<UserDTO>>() {
		};
		CollectionModel<UserDTO> userRes = traverson.follow("next").toObject(userType);

		Collection<UserDTO> users = userRes.getContent();
		System.out.println(users);
	}
}
