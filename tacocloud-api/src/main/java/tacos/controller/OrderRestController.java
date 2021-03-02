package tacos.controller;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import tacos.messages.OrderJmsMessgae;
import tacos.sender.OrderMessagingService;

@RepositoryRestController
@RequestMapping("orders")
public class OrderRestController {

	private final OrderMessagingService orderMessaging;

	public OrderRestController(OrderMessagingService orderMessaging) {
		super();
		this.orderMessaging = orderMessaging;
	}

	@GetMapping("/send")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void sendMessageToBroker() {

		orderMessaging.senOrder(new OrderJmsMessgae());

	}

}
