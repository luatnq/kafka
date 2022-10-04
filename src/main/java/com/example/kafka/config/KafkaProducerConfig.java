package com.example.kafka.config;

import com.example.kafka.converter.RequestSerializer;
import com.example.kafka.model.Request;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaProducerConfig extends KafkaProducerConfigBase<Request, RequestSerializer>{
  public KafkaProducerConfig() {
    super(RequestSerializer.class);
  }
}
