package tacos.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tacos.configuration.properties.OrderProps;
import tacos.domain.Order;
import tacos.domain.User;
import tacos.repositry.jdbc.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

	private final Logger log = LoggerFactory.getLogger(OrderController.class);

	private final OrderRepository orderRepo;

	private final OrderProps orderProps;

	public OrderController(OrderRepository orderRepo, OrderProps orderProps) {
		this.orderRepo = orderRepo;
		this.orderProps = orderProps;
	}

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@Valid Order order, Errors error, SessionStatus sessionStatus,
			@AuthenticationPrincipal User user) {
		if (error.hasErrors())
			return "orderForm";
		order.setUser(user);
		orderRepo.save(order);
		sessionStatus.setComplete();
		log.info("Order submitted: " + order);
		return "redirect:/";
	}

	@GetMapping("/forUser")
	public String orderForUser() {
		System.out.println("pageSize " + orderProps.getPageSize());
		return "home";
	}
}
