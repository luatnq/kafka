package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}",
            topics = "${message.kafka.topic-name1}",
            containerFactory = "listenerContainerFactory")
    public void receivedMessageForDump(String message)
    {
        System.out.println("Received message: " + message);
    }
}
