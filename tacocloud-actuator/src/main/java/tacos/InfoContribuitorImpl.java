package tacos;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoContribuitorImpl implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub
		Map<String, Object> details = new HashMap<>();
		details.put("Sponsor", "Nicholas Barbosa");
		details.put("Country", "Brazil");
		builder.withDetails(details);
	}

}
