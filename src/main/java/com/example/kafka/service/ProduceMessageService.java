package com.example.kafka.service;

import com.example.kafka.model.Request;
import com.example.kafka.service.base.ProducerServiceBaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProduceMessageService extends ProducerServiceBaseImpl<Request, KafkaTemplate<String, Request>> {

    public ProduceMessageService(KafkaTemplate<String, Request> kafkaTemplate) {
        super(kafkaTemplate);
    }

    @Autowired private KafkaTemplate<String, Request> kafkaTemplate;

    public void pushMessage(String topicName, Request message) {
        kafkaTemplate.send(topicName, message);
    }

}

