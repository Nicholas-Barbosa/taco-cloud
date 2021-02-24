package tacos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.data.UserCrudService;
import tacos.dto.RegistrationForm;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

	private final UserCrudService userCrudService;
	private final PasswordEncoder passwordEnconder;

	public UserRegistrationController(UserCrudService userCrudService, PasswordEncoder passwordEnconder) {
		super();
		this.userCrudService = userCrudService;
		this.passwordEnconder = passwordEnconder;
	}

	@ModelAttribute("form")
	public RegistrationForm registratioForm() {
		return new RegistrationForm();
	}

	@GetMapping
	public String registerForm() {
		return "registration";
	}

	@PostMapping
	public String processRegistration(@Valid RegistrationForm form, Errors erros, HttpServletRequest request) {
		if (erros.hasErrors()) 
			return "registration";
		userCrudService.save(form.toUser(passwordEnconder));
		return "redirect:/login";
	}
}
