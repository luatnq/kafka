//package com.example.kafka.service.impl;
//
//import static com.example.kafka.constant.KafkaConstant.TOPIC_NAME;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//
//public class KafkaServiceImpl {
//  @Autowired
//  private KafkaTemplate<String, String> kafkaTemplate;
//
//  public void sendMessage(String msg) {
//    kafkaTemplate.send(TOPIC_NAME, msg);
//  }
//
//}
