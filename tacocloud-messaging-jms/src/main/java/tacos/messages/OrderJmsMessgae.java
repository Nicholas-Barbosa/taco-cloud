package tacos.messages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class OrderJmsMessgae {

	private String name;

	private LocalDateTime messageSendAt;

	public OrderJmsMessgae() {
		super();
		this.name = "Test";
		this.messageSendAt = LocalDateTime.now();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "OrderJmsMessgae [name=" + name + ", messageSendAt="
				+ DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(messageSendAt) + "]";
	}

}
