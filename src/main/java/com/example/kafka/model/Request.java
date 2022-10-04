package com.example.kafka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.serializer.Deserializer;

import java.io.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {

  private String body;

}
