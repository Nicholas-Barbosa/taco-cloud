package tacos.receiver;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import tacos.messages.OrderJmsMessgae;

@Component
public class JmsOrderReceiverPullModel implements OrderReceiver {

	private final Logger log = LoggerFactory.getLogger(JmsOrderReceiverPullModel.class);

	private final JmsTemplate jmsTemplate;

	public JmsOrderReceiverPullModel(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public OrderJmsMessgae receiveOrder() throws MessageConversionException, JMSException {
		log.info("Pulling messages from broaker...");
		return (OrderJmsMessgae)  jmsTemplate.receiveAndConvert("tacocloud.order.queue");
	}

}
