package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.Producer;

@RestController
@RequestMapping("/kafka")
public class Controller {

	@Autowired
	Producer producer;
	
	@PostMapping("/publish")
	public void sendMessage(@RequestParam("message")String message) {
		this.producer.sendMessage(message);
	}
}
