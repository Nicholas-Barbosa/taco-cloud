package tacos.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import tacos.domain.Order;

@Service
public class JmsOrderMessagingService implements OrderMessagingService, CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(JmsOrderMessagingService.class);
	private final JmsTemplate jmsTemplate;

	public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public void senOrder(Order order) {
//		jmsTemplate.send("tacocloud.order.queue", s -> s.createObjectMessage(order)
//				);
		log.info("Sending message to broaker...");
		jmsTemplate.convertAndSend("DLQ", order, m -> {
			m.setStringProperty("X_ORDER_SOURCE", "WEB");
			return m;
		});
		log.info("Message sent!");
	}

	@Override
	public void run(String... args) throws Exception {
		this.senOrder(new Order());

	}

}
