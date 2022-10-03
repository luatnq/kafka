package com.example.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.serializer.Deserializer;

import java.io.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request implements Serializable, Deserializer<Request> {
  private String body;

  @Override
  public Request deserialize(InputStream inputStream) throws IOException {
    try(ByteArrayInputStream bis = new ByteArrayInputStream(inputStream);
        ObjectInputStream in = new ObjectInputStream(bis)) {
      return (Request) in.readObject();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
