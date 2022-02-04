package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private HelloWorldKafkaProducer helloWorldKafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloWorldKafkaProducer.sendHelloWorld(UUID.randomUUID().toString());
	}
}