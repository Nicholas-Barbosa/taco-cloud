package tacos.sender;

import tacos.domain.Order;

public interface OrderMessagingService {
	
	void senOrder(Order order);

}
