package tacos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.data.UserCrudService;
import tacos.domain.User;
import tacos.dto.UserDTO;

@RequestMapping("/api/user")
@RestController
public class UserRestController {

	private final UserCrudService userCrudService;

	public UserRestController(UserCrudService userCrudService) {
		super();
		this.userCrudService = userCrudService;
	}

	@GetMapping
	public List<UserDTO> showUsers() {
		List<UserDTO> users = new ArrayList<>();
		Consumer<User> c = u -> users.add(UserDTO.toDTO(u));
		userCrudService.findAll().forEach(c);
		return users;
	}

	@GetMapping("/links")
	public CollectionModel<EntityModel<UserDTO>> showUsersWithLinks() {
		/*
		 * Resources now is CollectionModel
		 * 
		 * Resource now is EntityModel
		 */
		List<UserDTO> users = new ArrayList<>();
		Consumer<User> c = u -> users.add(UserDTO.toDTO(u));
		userCrudService.findAll().forEach(c);

		CollectionModel<EntityModel<UserDTO>> resources = CollectionModel.wrap(users);

		resources.add(WebMvcLinkBuilder.linkTo(UserRestController.class).slash("/links").withRel("users"));
		return resources;
	}
}
