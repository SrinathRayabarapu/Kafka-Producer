package com.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MultiplePartitionsKafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendDataToMultiplePartitions(String key, String data){
        log.info("Sending key :{} data :{}", key, data);
        kafkaTemplate.send("t_multi_partitions", key, data);
    }

}
