package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendHelloWorld(String someString) {
        kafkaTemplate.send("t_test_topic", "Hello World! - " + someString);
    }

}
