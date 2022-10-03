package com.example.kafka.config;

import com.example.kafka.model.Request;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaProducerConfig extends KafkaProducerConfigBase<Request>{
  public KafkaProducerConfig() {
    super(Request.class);
  }
}
