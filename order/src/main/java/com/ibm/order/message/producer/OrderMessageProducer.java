package com.ibm.order.message.producer;

public interface OrderMessageProducer {

	void sendMessage(String writeValueAsString);

}
