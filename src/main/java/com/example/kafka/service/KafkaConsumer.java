package com.example.kafka.service;

import com.example.kafka.model.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}",
            topics = "payment-transaction",
            containerFactory = "listenerContainerFactory")
    public void receivedMessageForDump(Request message)
    {
        System.out.println("Received message: " + message);
    }
}
