package tacos.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import tacos.messages.OrderJmsMessgae;

@Profile("messaging-jms")
@Component
public class OrderListener implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(OrderListener.class);

	@JmsListener(destination = "tacocloud.order.queue")
	public void receiveOrder(OrderJmsMessgae order) {
		log.info("New message has arrived! " + order);
	}

	@Override
	public void run(String... args) throws Exception {
		receiveOrder(null);
	}
}
