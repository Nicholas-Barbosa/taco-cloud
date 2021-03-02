package tacos.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.persistence.criteria.Order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

@Configuration
public class CovariantMessageConverterConfig {

	@Bean
	public MappingJackson2MessageConverter messageConverter() {
		MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
		messageConverter.setTypeIdPropertyName("_typeId");
		Map<String,Class<?>>typeIdMappings = new HashMap<String,Class<?>>();
		typeIdMappings.put("order",Order.class);
		messageConverter.setTypeIdMappings(typeIdMappings);
		
		return messageConverter;
	}
}
