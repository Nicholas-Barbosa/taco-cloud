package tacos.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import tacos.messagestemplates.OrderAmqpTemplate;
import tacos.receiver.PullBasedReceiver;

@Profile("messaging-rbmq")
@Service
public class RabbitMqOrderMessagingService implements OrderAMQPMessagingService, CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(RabbitMqOrderMessagingService.class);

	private final RabbitTemplate rabbit;

	public RabbitMqOrderMessagingService(RabbitTemplate rabbit) {
		super();
		this.rabbit = rabbit;
	}

	@Override
	public void sendOrder(OrderAmqpTemplate templateMessaging) {
		log.info("Sending message to rabbitmq broker...");
//		MessageConverter messageConverter = rabbit.getMessageConverter();
//		MessageProperties props = new MessageProperties();
//		Message message = messageConverter.toMessage(templateMessaging, props);
//		rabbit.send("tacocloud.orders", "tacocloud.order", message);
		// por isso
		rabbit.convertAndSend("tacocloud.orders", "tacocloud.order", templateMessaging, m -> {
			MessageProperties props = m.getMessageProperties();
			props.setHeader("X_ORDER_SOURCE", "WEB");
			return m;
		});
		log.info("Message sent!");

	}

	@Override
	public void run(String... args) throws Exception {
		sendOrder(new OrderAmqpTemplate("HelloWorld rabbitmq!"));
	}

}
