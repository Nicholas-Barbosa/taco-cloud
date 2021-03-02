package tacos.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tacos.messagestemplates.OrderAmqpTemplate;

public class PushBasedOrderReceiver implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(PushBasedOrderReceiver.class);
	
	@RabbitListener(queues = "tacocloud.order.queue")
	public void receiveOrder(OrderAmqpTemplate order) {
		log.info("New message: " +order);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
