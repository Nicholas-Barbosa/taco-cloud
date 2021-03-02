package tacos;

import java.nio.file.Path;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;

@Configuration
public class FileWriterIntegrationConfig {

	// T = return type S = param type
	@Bean
	@Transformer(inputChannel = "textInChanner", outputChannel = "fileWriterChanner")
	public GenericTransformer<String, String> upperCaseTransformer() {
		System.out.println("transformer");
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
}
