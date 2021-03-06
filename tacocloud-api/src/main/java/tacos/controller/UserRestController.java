package tacos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tacos.data.UserCrudService;
import tacos.domain.User;
import tacos.dto.UserDTO;
import tacos.representationmodel.UserRepresentationModel;
import tacos.representationmodel.assemblers.UserRepresentationModelAssembler;

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
	public CollectionModel<UserRepresentationModel> showUsersWithLinks() {
		/*
		 * Resources now is CollectionModel
		 * 
		 * Resource now is EntityModel
		 */

		List<User> modelUsers = new ArrayList<User>();

		userCrudService.findAll().forEach(modelUsers::add);

		CollectionModel<UserRepresentationModel> users = new UserRepresentationModelAssembler()
				.toCollectionModel(modelUsers);

		users.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserRestController.class).showUsers())
				.withRel("users"));
		return users;
	}
}
