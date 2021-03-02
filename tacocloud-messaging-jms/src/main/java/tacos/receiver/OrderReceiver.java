package tacos.receiver;

import tacos.messages.OrderJmsMessgae;

public interface OrderReceiver {

	OrderJmsMessgae receiveOrder() throws Exception;
}
