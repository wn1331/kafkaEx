package com.example.orderproducer.adapter.controller;

import com.example.orderproducer.domain.MessageProcessor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ex")
public class ExampleController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageProcessor messageProcessor;

    public ExampleController(KafkaTemplate<String, String> kafkaTemplate, MessageProcessor messageProcessor) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageProcessor = messageProcessor;
    }


    @PostMapping("/send")
    public void send(@RequestBody String msg){
        kafkaTemplate.send(new ProducerRecord<>("exampleMessage",msg));

        System.out.println("프로듀서가 전송한 메시지 : "+msg);
    }
//    @KafkaListener(topics = "exampleMessage",groupId = "exampleGroupId")
//    public void receiveMessage(ConsumerRecord<String,String> record) {
//        messageProcessor.processMessage(record.value());
//    }
}
