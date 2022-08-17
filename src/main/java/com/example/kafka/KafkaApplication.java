package com.example.kafka;

import com.example.kafka.service.MessageListener;
import com.example.kafka.service.MessageProducer;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(KafkaApplication.class, args);

		MessageListener messageListener = new MessageListener();
		MessageProducer messageProducer = new MessageProducer();

		messageProducer.sendMessage("Hello, World!");
		messageListener.getLatch().await(10, TimeUnit.SECONDS);
	}

}
