package com.learningclix.deliveryboy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningclix.deliveryboy.service.KafkaService;

@RestController
@RequestMapping("/boy-location")
public class BoyLocationController {

    @Autowired
    private KafkaService kafkaService;

    /**
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<?> updateBoyLocation() {
        this.kafkaService.updateBoyLocation(
                "( " + Math.round(Math.random() * 1000) + " , " + Math.round(Math.random() * 1000) + " )");
        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
    }

}