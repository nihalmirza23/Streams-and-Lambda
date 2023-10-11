package com.apache.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.apache.kafka.model.User;

@Service
public class jsonKafkaConsumer {

	private static final Logger log = LoggerFactory.getLogger(jsonKafkaConsumer.class);
	
	@KafkaListener(topics = "json-topic",groupId = "MyGroup")
	public void consumer(User user) {
		log.info("User get -> "+ user.toString());
	}
}
