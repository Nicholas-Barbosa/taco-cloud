package tacos.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import tacos.data.UserCrudService;
import tacos.domain.User;
import tacos.representationmodel.UserRepresentationModel;
import tacos.representationmodel.assemblers.UserRepresentationModelAssembler;

@RepositoryRestController
public class UserRepoRestController {

	private final UserCrudService userCrudService;

	public UserRepoRestController(UserCrudService userCrudService) {
		super();
		this.userCrudService = userCrudService;
	}

	@GetMapping("/users")
	public ResponseEntity<CollectionModel<UserRepresentationModel>> showUsers() {
		System.out.println("data rest!");
		List<User> modelUsers = userCrudService.findAll(PageRequest.of(0, 2)).getContent();
		CollectionModel<UserRepresentationModel> users = new UserRepresentationModelAssembler()
				.toCollectionModel(modelUsers);
		return new ResponseEntity<CollectionModel<UserRepresentationModel>>(users, HttpStatus.FOUND);

	}
}
