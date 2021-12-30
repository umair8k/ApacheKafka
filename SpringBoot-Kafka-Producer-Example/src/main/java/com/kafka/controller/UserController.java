package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.User;

@RestController
@RequestMapping("/kafka")
public class UserController {
	private static final String TOPIC="Kafka_Example";
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemlate;
	
	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		kafkaTemlate.send(TOPIC, new User(name, "IT", 25000l));
		return "MessagePublished";
	}
	

}
