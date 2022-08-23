package com.example.kafka.controller;

import com.example.kafka.service.ProduceMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaControler {


    @Autowired
    private ProduceMessageService produceMessageService;

    @PostMapping("/kafka-push")
    public void kafkaProducerApi(@RequestBody String message)
    {
        System.out.println(message);
        produceMessageService.pushMessage(message);
    }
}
