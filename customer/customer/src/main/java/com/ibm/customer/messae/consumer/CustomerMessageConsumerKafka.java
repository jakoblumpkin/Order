package com.ibm.customer.messae.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerMessageConsumerKafka implements CustomerMessageConsumer {
   
	private final Logger logger = LoggerFactory.getLogger(CustomerMessageConsumerKafka.class);
	
	@Value("${kafka.topic.name:added-order-c49gpd4f08embkrfhvqg}")
	private String topicName;
	
	@KafkaListener(topics = "added-order-c49gpd4f08embkrfhvqg", groupId = "Order")
	public void consumeMessage(String addedBookMsg) {
		logger.info("received message {}", addedBookMsg);
	}
}
