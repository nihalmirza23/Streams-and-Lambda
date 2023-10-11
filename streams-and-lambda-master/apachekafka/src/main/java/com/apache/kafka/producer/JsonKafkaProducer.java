package com.apache.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.apache.kafka.model.User;

@Service
public class JsonKafkaProducer {
	
	private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendjsonMessage(User user) {
		
		log.info("message sennd -> "+ user.toString());
		
		kafkaTemplate.send("json-topic", user);
	}
}
