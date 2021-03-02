package tacos.sender;

import tacos.messagestemplates.OrderAmqpTemplate;

public interface OrderAMQPMessagingService {

	void sendOrder(OrderAmqpTemplate templateMessaging);
}
