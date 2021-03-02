package tacos.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tacos.messagestemplates.OrderAmqpTemplate;

public class PullBasedReceiver implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(PullBasedReceiver.class);

	private final RabbitTemplate rabbit;
	private final MessageConverter msgConverter;

	public PullBasedReceiver(RabbitTemplate rabbit, MessageConverter msgConverter) {
		super();
		this.rabbit = rabbit;
		this.msgConverter = msgConverter;
	}

	public OrderAmqpTemplate receiveOrder() {
		log.info("Message ha been taken");
		// return (OrderAmqpTemplate) rabbit.receive("tacocloud.order");
		Message message = rabbit.receive("tacocloud.order");
		return message != null ? (OrderAmqpTemplate) msgConverter.fromMessage(message) : null;
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Message: " + this.receiveOrder());

	}
}
