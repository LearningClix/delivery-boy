package com.learningclix.deliveryboy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.learningclix.deliveryboy.config.Constants;

@Service
public class KafkaService {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateBoyLocation(String location){
        this.kafkaTemplate.send(Constants.BOY_LOCATION_TOPIC_NAME, location);
        return true;
    }
}
