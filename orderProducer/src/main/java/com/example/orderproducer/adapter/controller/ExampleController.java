package com.example.orderproducer.adapter.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex")
public class ExampleController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ExampleController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/send")
    public void send(@RequestBody String msg){
        kafkaTemplate.send(new ProducerRecord<>("exampleMessage",msg));

        System.out.println("프로듀서가 전송한 메시지 : "+msg);
    }
}
