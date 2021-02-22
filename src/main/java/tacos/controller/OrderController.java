package tacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {

	private final Logger log = LoggerFactory.getLogger(OrderController.class);

	@GetMapping("/current")
	public String orderForm(Model model) {
		return "orderForm";
	}
}
