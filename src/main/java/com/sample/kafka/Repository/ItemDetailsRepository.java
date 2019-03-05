package com.sample.kafka.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.kafka.ItemDetails;

public interface ItemDetailsRepository extends MongoRepository<ItemDetails, Integer>{

}
