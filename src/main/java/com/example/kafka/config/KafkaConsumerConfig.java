package com.example.kafka.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class KafkaConsumerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServerAddress;
  @Value("${spring.kafka.consumer.group-id}")
  private String groupId;


  @Bean
  public ConsumerFactory<String, String> consumerFactory()
  {
    Map<String, Object> configMap = new HashMap<>();
    configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServerAddress);
    configMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    //configMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 256);     // uncomment if want to get a bulk of message
    configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
    return new DefaultKafkaConsumerFactory<>(configMap);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory()
  {
    ConcurrentKafkaListenerContainerFactory<String, String> kafkaListener = new ConcurrentKafkaListenerContainerFactory();
    kafkaListener.setConsumerFactory(consumerFactory());
    //kafkaListener.setBatchListener(true);     // uncomment if want to get a bulk of message
    return kafkaListener;
  }

}
