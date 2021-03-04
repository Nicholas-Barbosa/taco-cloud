package tacos.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "tacocloud.email")
@Component
public class EmailProperties {

	private String username;
	private String password;
	private String host;
	private String mailbox;
	private long pollRate = 30000;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public long getPollRate() {
		return pollRate;
	}

	public void setPollRate(long pollRate) {
		this.pollRate = pollRate;
	}

	public String getImapUrl() {
		
		return String.format("imaps://%s:%s@%s/%s", this.username, this.password, this.host, this.mailbox);
	}
}
