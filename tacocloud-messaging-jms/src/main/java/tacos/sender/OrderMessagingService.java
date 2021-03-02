package tacos.sender;

import tacos.messages.OrderJmsMessgae;

public interface OrderMessagingService {

	void senOrder(OrderJmsMessgae order);

}