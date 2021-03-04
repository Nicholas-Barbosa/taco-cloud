package tacos;

import org.springframework.context.annotation.Profile;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import tacos.properties.ApiProperties;
@Profile("email-flow")
@Component
public class OrderSubmitMessageHandler implements GenericHandler<OrderConvertedFromEmail> {

	private final RestTemplate rest;
	private final ApiProperties apiProps;

	public OrderSubmitMessageHandler(RestTemplate rest, ApiProperties apiProps) {
		super();
		this.rest = rest;
		this.apiProps = apiProps;
	}

	@Override
	public Object handle(OrderConvertedFromEmail payload, MessageHeaders headers) {
		// TODO Auto-generated method stub
		rest.postForObject(apiProps.getUrl(), payload, String.class);
		return null;
	}

}
