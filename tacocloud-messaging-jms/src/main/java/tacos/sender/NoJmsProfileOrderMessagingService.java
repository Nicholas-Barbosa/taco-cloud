package tacos.sender;

import org.springframework.stereotype.Service;

import tacos.messages.OrderJmsMessgae;

@Service
public class NoJmsProfileOrderMessagingService implements OrderMessagingService {

	

	@Override
	public void senOrder(OrderJmsMessgae order) {
		// TODO Auto-generated method stub

	}

}
