package com.example.kafka.postgressToMongo.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC = "mysql-mongo";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message)
    {
        this.kafkaTemplate.send(TOPIC, message);
    }
}
