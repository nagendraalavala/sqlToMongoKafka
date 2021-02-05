package com.example.kafka.postgressToMongo;

import com.example.kafka.postgressToMongo.publisher.Producer;
import com.example.kafka.postgressToMongo.service.DbToTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private DbToTopicService service;

    private final Producer producer;

    @Autowired
    public Controller(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/produce")
    public void kafkaproducer()
    {
        service.getAllEmployeProfilesAndPublishToKafka();
    }

    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") String message)
    {
        this.producer.sendMessage(message);
    }



}
