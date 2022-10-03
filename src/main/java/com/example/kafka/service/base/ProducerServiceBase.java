package com.example.kafka.service.base;

public interface ProducerServiceBase<T> {
  void pushMessage(String topicName, T message);
}
