package tacos.receiver;

import javax.jms.JMSException;
import javax.jms.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import tacos.domain.Order;
public class JmsOrderReceiverPullModel implements OrderReceiver,CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(JmsOrderReceiverPullModel.class);
	
	private final JmsTemplate jmsTemplate;
	private final MessageConverter messageConverter;

	public JmsOrderReceiverPullModel(JmsTemplate jmsTemplate, MessageConverter messageConverter) {
		super();
		this.jmsTemplate = jmsTemplate;
		this.messageConverter = messageConverter;
	}

	@Override
	public Order receiveOrder() throws MessageConversionException, JMSException {
		log.info("Pulling messages from broaker...");
		Message message = jmsTemplate.receive("tacocloud.order.queue");

		return (Order) messageConverter.fromMessage(message);
	}

	@Override
	public void run(String... args) throws Exception {
		receiveOrder();
		
	}

}
