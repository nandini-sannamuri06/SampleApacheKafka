package com.sample.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sample.kafka.Repository.ItemDetailsRepository;

@Component
public class KafkaListner {
	 
	@Autowired
	ItemDetailsRepository itemDetailsRepository;
	
	 @KafkaListener(topics= {"SAMPLE_TEST_TOPIC"}, groupId = "group-id")
	    public void listenPartition0(ConsumerRecord<?, ?> record) {
	        System.out.println("Received: " + record.value());
	        itemDetailsRepository.save(new Gson().fromJson(record.value().toString(),ItemDetails.class));
	    }
}
