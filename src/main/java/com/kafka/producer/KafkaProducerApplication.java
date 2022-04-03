package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
//@EnableScheduling
public class KafkaProducerApplication implements CommandLineRunner {

	@Autowired
	private MultiplePartitionsKafkaProducer multiplePartitionsKafkaProducer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int i = 0;
		while (i < 200){
			multiplePartitionsKafkaProducer.sendDataToMultiplePartitions("key-"+i%3, UUID.randomUUID().toString());
			i++;
			Thread.sleep(2000);
		}
	}

}