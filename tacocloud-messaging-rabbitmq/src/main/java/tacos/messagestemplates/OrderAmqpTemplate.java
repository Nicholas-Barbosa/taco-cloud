package tacos.messagestemplates;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OrderAmqpTemplate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private LocalDateTime sendAt;

	public OrderAmqpTemplate(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getSendAt() {
		return sendAt;
	}

}
