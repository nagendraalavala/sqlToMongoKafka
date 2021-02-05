package com.example.kafka.postgressToMongo.consumer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class KafkaConsumer {
    @KafkaListener(topics = "mysql-mongo", groupId = "test-consumer-group")
    public void listen(Object message) {
        System.out.println("Received Messasge in group - test-consumer-group: " + message);

    }
}
