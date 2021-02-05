package com.example.kafka.postgressToMongo.service;


import com.example.kafka.postgressToMongo.publisher.KafkaPublisher;
import com.example.kafka.postgressToMongo.repository.EmployeeDAO;
import com.example.kafka.postgressToMongo.repository.SQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbToTopicService {
    @Autowired
    SQLRepository sqlRepository;

    @Autowired
    KafkaPublisher kafkaPublisher;


public void getAllEmployeProfilesAndPublishToKafka(){


 List<EmployeeDAO> employeeDAOS = sqlRepository.getAllEmployeeDetails();
    kafkaPublisher.sendMessage(employeeDAOS.toString());
}

}
