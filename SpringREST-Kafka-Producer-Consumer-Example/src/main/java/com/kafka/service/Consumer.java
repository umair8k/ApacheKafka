package com.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer {

	@KafkaListener(topics="mytopic",groupId="group_id")
	
	public void consumer(String message) {
		System.out.println("Consumed Message: "+message);
	}
}
