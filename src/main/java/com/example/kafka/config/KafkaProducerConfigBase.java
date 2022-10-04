package com.example.kafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


public class KafkaProducerConfigBase<T, S> {

  private final Class<S> sClass;

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServerAddress;

  public KafkaProducerConfigBase(Class<S> sClass) {
    this.sClass = sClass;
  }

  @Bean
  public ProducerFactory<String, T> producerFactory()
  {
    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
    configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, sClass);
    return new DefaultKafkaProducerFactory<String, T>(configMap);
  }

  @Bean
  public KafkaTemplate<String, T> kafkaTemplate()
  {
    return new KafkaTemplate<>(producerFactory());
  }
}
