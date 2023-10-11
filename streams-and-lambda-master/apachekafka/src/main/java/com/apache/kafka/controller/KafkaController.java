package com.apache.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apache.kafka.model.User;
import com.apache.kafka.producer.JsonKafkaProducer;
import com.apache.kafka.producer.KafkaProducer;

@RestController
public class KafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
	private JsonKafkaProducer jsonKafkaProducer;
	
	@GetMapping("/api/string")
	public String postMessage(@RequestParam("message") String message) {
		
		kafkaProducer.sendMessgae(message);
		return "messge sent successfully";	
	}
	
	@PostMapping("/api/json")
	public String postMessageByJson(@RequestBody User user) {
		
		jsonKafkaProducer.sendjsonMessage(user);
		
		return "user sent successfully";	
	}
}
