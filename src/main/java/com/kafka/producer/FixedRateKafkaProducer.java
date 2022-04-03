package com.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.UUID;

@Slf4j
//@Service
public class FixedRateKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedDelay = 2000)
    public void sendFixedData(){
        String message = "MSG - " + UUID.randomUUID();
        log.info("Sending message : {}", message);
        kafkaTemplate.send("t_test_topic", message);
    }

}
