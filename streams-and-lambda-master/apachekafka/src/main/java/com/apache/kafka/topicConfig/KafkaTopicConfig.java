package com.apache.kafka.topicConfig;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	
	//We need to create a topic bean to create the topic 
	@Bean
	public NewTopic newTopic() {
		
		// user topic builder to create the topic
		return TopicBuilder.name("topic-demo")
//				We can give the partitions if not then kafka internally creates the partions.
//						.partitions(0)
						.build();
	}
	
	@Bean
	public NewTopic jsonTopic() {
		return TopicBuilder.name("json-topic")
					.build();
	}
}
