package com.example.kafka.postgressToMongo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "mysql-mongo", groupId = "test-consumer-group")
    public void consumeMessage(String message) {
        System.out.println("Received Messasge in group - test-consumer-group: " + message);

    }
}
