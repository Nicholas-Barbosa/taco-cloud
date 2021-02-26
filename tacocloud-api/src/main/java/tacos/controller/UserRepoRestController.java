package tacos.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
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

	private final PagedResourcesAssembler<User> pagedResourceAssembler;

	public UserRepoRestController(UserCrudService userCrudService,
			PagedResourcesAssembler<User> pagedResourceAssembler) {
		super();
		this.userCrudService = userCrudService;
		this.pagedResourceAssembler = pagedResourceAssembler;
	}

	@GetMapping("/users")
	public ResponseEntity<PagedModel<UserRepresentationModel>> showUsers() {
		Page<User> modelUsers = userCrudService.findAll(PageRequest.of(0, 2));
		PagedModel<UserRepresentationModel> users = pagedResourceAssembler.toModel(modelUsers,
				new UserRepresentationModelAssembler());

		return new ResponseEntity<PagedModel<UserRepresentationModel>>(users, HttpStatus.FOUND);

	}

	@GetMapping("/users/collectionModel")
	public ResponseEntity<CollectionModel<UserRepresentationModel>> showUsersCollectionModel() {
		Set<User> entityUsers = new HashSet<>();
		userCrudService.findAll().forEach(entityUsers::add);

		CollectionModel<UserRepresentationModel> collectionModels = new UserRepresentationModelAssembler()
				.toCollectionModel(entityUsers);

		return new ResponseEntity<CollectionModel<UserRepresentationModel>>(collectionModels, HttpStatus.FOUND);

	}
}
