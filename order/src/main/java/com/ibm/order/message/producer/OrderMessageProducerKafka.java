package com.ibm.order.message.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageProducerKafka implements OrderMessageProducer {
	
	private final Logger logger = LoggerFactory.getLogger(OrderMessageProducerKafka.class);

	@Value("${kafka.topic.name:added-order-c49gpd4f08embkrfhvqg}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String message) {
		logger.info("Writing message to topic {}", topicName);
		kafkaTemplate.send(topicName, message);
	}
}
