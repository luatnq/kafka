package com.example.kafka.service.base;

import org.springframework.kafka.core.KafkaTemplate;


public abstract class ProducerServiceBaseImpl<T, K extends KafkaTemplate<String, T>> implements ProducerServiceBase<T> {

  private final K kafkaTemplate;

  protected ProducerServiceBaseImpl(K kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void pushMessage(String topicName, T message) {
    kafkaTemplate.send(topicName, message);
  }

}

