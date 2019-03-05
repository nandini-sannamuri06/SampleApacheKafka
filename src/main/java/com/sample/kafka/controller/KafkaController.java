package com.sample.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.kafka.ItemDetails;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	
	@PostMapping(value="/sender")
	public ResponseEntity<String> sendData(@RequestBody ItemDetails data) {
		kafkaTemplate.send("SAMPLE_TEST_TOPIC", data.toString());
		return new ResponseEntity<String>("Data sent successfully",HttpStatus.OK);
	}
	

}
