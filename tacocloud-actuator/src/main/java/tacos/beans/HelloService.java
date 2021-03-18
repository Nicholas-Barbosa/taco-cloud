package tacos.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class HelloService {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public String sayHello() {
		return message;
	}
}
