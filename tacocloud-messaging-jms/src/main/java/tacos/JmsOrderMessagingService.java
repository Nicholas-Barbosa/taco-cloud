package tacos;

import org.springframework.jms.core.JmsTemplate;

import tacos.domain.Order;

public class JmsOrderMessagingService implements OrderMessagingService {

	private final JmsTemplate jmsTemplate;

	public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public void senOrder(Order order) {
//		jmsTemplate.send("tacocloud.order.queue", s -> s.createObjectMessage(order)
//				);
		jmsTemplate.convertAndSend("tacocloud.order.queue",order);

	}

}
