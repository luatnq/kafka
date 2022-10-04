//package com.example.kafka.converter.base;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.common.errors.SerializationException;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.util.Map;
//
//public class CustomDeserializer<T> implements Deserializer<T> {
//  private ObjectMapper objectMapper = new ObjectMapper();
//  private final Class<T> tClass;
//
//  public CustomDeserializer(Class<T> tClass) {
//    this.tClass = tClass;
//  }
//
//  @Override
//  public void configure(Map<String, ?> configs, boolean isKey) {
//  }
//
//  @Override
//  public T deserialize(String topic, byte[] data) {
//    try {
//      if (data == null) {
//        System.out.println("Null received at deserializing");
//        return null;
//      }
//      System.out.println("Deserializing...");
//      return objectMapper.readValue(new String(data, "UTF-8"), tClass);
//    } catch (Exception e) {
//      throw new SerializationException("Error when deserializing byte[] to MessageDto");
//    }
//  }
//
//  @Override
//  public void close() {
//  }
//}
