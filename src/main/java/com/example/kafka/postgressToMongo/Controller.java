package com.example.kafka.postgressToMongo;

import com.example.kafka.postgressToMongo.service.DbToTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private DbToTopicService service;

    @GetMapping("/produce")
    public void kafkaproducer()
    {
        service.getAllEmployeProfilesAndPublishToKafka();
    }
}
