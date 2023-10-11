package com.apache.kafka.producer;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
public class KafkaProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class); 
	
	private KafkaTemplate<String, String > kafkaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	public void sendMessgae(String message) {
		logger.info("messgae sent -> "+message);
		kafkaTemplate.send("topic-demo", message);
		
	}
}
