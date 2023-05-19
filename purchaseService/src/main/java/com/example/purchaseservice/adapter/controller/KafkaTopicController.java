package com.example.purchaseservice.adapter.controller;

import com.example.purchaseservice.domain.MessageProcessor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaTopicController {

//    @PostMapping("/purchase")
//    public void purchase(){
//        System.out.println("결제완료");
//        //postgreSQL db update
//    }
    private final MessageProcessor messageProcessor;

    private static final String TOPIC = "exampleMessage";

    public KafkaTopicController(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }

    @KafkaListener(topics = TOPIC, groupId = "exampleGroupId")
    public void receiveMessage(ConsumerRecord<String,String> record) {
        messageProcessor.processMessage(record.value());
    }
}
