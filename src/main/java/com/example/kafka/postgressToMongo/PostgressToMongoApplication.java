package com.example.kafka.postgressToMongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class PostgressToMongoApplication implements ApplicationRunner {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg) {
		kafkaTemplate.send("mysql-mongo", msg);
	}
	@KafkaListener(topics = "mysql-mongo", groupId = "test-consumer-group")
	public void listen(String message) {
		System.out.println("Received Messasge in group - test-consumer-group: " + message);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		sendMessage("Hi Welcome to Spring For Apache Kafka");
	}

	public static void main(String[] args) {
		SpringApplication.run(PostgressToMongoApplication.class, args);
	}

}
