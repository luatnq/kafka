package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProduceMessageService {

    @Value("${message.kafka.topic-name1}")
    private String firstTopic;


    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void pushMessage(String message)
    {
        kafkaTemplate.send(firstTopic, message);
    }
}

