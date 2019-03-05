package com.sample.kafka.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sample.kafka.ItemDetails;
import com.sample.kafka.Repository.ItemDetailsRepository;

@RestController
public class KafkaController {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	ItemDetailsRepository itemDetailsRepository;
	
	
	@PostMapping(value="/sender")
	public ResponseEntity<String> sendData(@RequestBody String data) {
		kafkaTemplate.send("SAMPLE_TEST_TOPIC", data.toString());
		return new ResponseEntity<String>("Data sent successfully",HttpStatus.OK);
	}
	
	@GetMapping(value="/fetchDetails")
	public ResponseEntity<String> fetchData(@RequestParam Integer itemId) {
		Optional<ItemDetails> itemDetails = itemDetailsRepository.findByItemId(itemId);
		if(itemDetails.isPresent()) {
		String data = new Gson().toJson(itemDetails);
		kafkaTemplate.send("SAMPLE_RECEIVE_TOPIC", data);
		return new ResponseEntity<>("Data successfully sent",HttpStatus.OK);
		}else {
			System.out.println("Item Details are not available");
			return new ResponseEntity<String>("Item Details are not available",HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
