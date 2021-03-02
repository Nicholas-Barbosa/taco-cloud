package tacos.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

import tacos.messages.OrderJmsMessgae;

@Configuration
public class CovariantMessageConverterConfig {

	@Bean
	public MappingJackson2MessageConverter messageConverter() {
		MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
		messageConverter.setTypeIdPropertyName("_typeId");
		
		Map<String,Class<?>>typeIdMappings = new HashMap<String,Class<?>>();
		typeIdMappings.put("order",OrderJmsMessgae.class);
		messageConverter.setTypeIdMappings(typeIdMappings);
		
		return messageConverter;
	}
}
