package tacos;

import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

@Configuration
public class FileWriterIntegrationConfig {

	// T = return type S = param type
	@Bean
	@Transformer(inputChannel = "textInChanner", outputChannel = "fileWriterChanner")
	public GenericTransformer<String, String> upperCaseTransformer() {
		return text -> text.toUpperCase();
	}

	@Bean
	@ServiceActivator(inputChannel = "fileWriterChannel")
	public FileWritingMessageHandler fileWriter() {
		FileWritingMessageHandler handler = new FileWritingMessageHandler(Path.of("/home/c").toFile());
		handler.setExpectReply(false);
		handler.setFileExistsMode(FileExistsMode.APPEND);
		handler.setAppendNewLine(true);
		return handler;
	}

	@Bean
	@InboundChannelAdapter(poller = @Poller(fixedRate = "1000"), channel = "numberChannel")
	public MessageSource<Integer> numberSource(AtomicInteger source) {
		System.out.format("source %S", source);
		return () -> {
			return new GenericMessage<Integer>(source.getAndIncrement());
		};
	}

	@Bean
	public AtomicInteger atomic() {
		return new AtomicInteger();
	}
	@Bean
	public MessageChannel numberChannel() {
		return new PublishSubscribeChannel();
	}
}
