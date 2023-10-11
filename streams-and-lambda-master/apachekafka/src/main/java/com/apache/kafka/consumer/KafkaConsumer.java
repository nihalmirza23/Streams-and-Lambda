package com.apache.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class); 
	
	@KafkaListener(topics = "topic-demo", groupId = "MyGroup")
	public void consumer(String message) {
		log.info("message received -> "+message);
	}
	
	
}
