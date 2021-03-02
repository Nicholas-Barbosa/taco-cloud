package tacos.receiver;

import tacos.domain.Order;

public interface OrderReceiver {

	Order receiveOrder() throws Exception;
}
