package tacos;

import javax.mail.Message;

import org.springframework.context.annotation.Profile;
import org.springframework.integration.mail.transformer.AbstractMailMessageTransformer;
import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;
@Profile("email-flow")
@Component
public class EmailToOrderTransformer extends AbstractMailMessageTransformer<OrderConvertedFromEmail> {

	@Override
	protected AbstractIntegrationMessageBuilder<OrderConvertedFromEmail> doTransform(Message mailMessage)
			throws Exception {
		OrderConvertedFromEmail tacoOrder = processPayload(mailMessage);
		return MessageBuilder.withPayload(tacoOrder);
	}

	private OrderConvertedFromEmail processPayload(Message mailMessage) {
		// TODO Auto-generated method stub
		return null;
	}

}
