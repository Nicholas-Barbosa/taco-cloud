package tacos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
}
