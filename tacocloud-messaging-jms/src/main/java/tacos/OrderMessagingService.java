package tacos;

import tacos.domain.Order;

public interface OrderMessagingService {
	
	void senOrder(Order order);

}
