package com.example.purchaseservice.adapter.controller;

import com.example.purchaseservice.domain.MessageProcessor;
import com.example.purchaseservice.domain.OrderEvent;
import com.example.purchaseservice.domain.OrderProcessor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.jetbrains.annotations.NotNull;
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
    private final OrderProcessor orderProcessor;
    private static final String TOPIC = "orderId";

    public KafkaTopicController(MessageProcessor messageProcessor, OrderProcessor orderProcessor) {
        this.messageProcessor = messageProcessor;
        this.orderProcessor = orderProcessor;
    }

    @KafkaListener(topics = "exampleMessage", groupId = "exampleGroupId")
    public void receiveMessage(ConsumerRecord<String,String> record) {
        messageProcessor.processMessage(record.value());
    }

    @KafkaListener(topics = TOPIC, groupId = "orderGroupId")
    public void receiveOrder(ConsumerRecord<String,String> record){
        orderProcessor.processOrder(record.value());
    }
}
