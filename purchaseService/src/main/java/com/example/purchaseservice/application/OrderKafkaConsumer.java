//package com.example.purchaseservice.application;
//
//import com.example.purchaseservice.domain.OrderEvent;
//import org.apache.kafka.common.errors.TimeoutException;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class OrderKafkaConsumer {
//
//    private static final String TOPIC = "order";
//
//    @KafkaListener(topics = TOPIC, groupId = "orders", errorHandler = "myKafkaListenerErrorHandler")
//    public void consumeOrder(OrderEvent event) throws TimeoutException {
//        System.out.println("Consume 성공! -> Received " + event.getOrderName());
//    }
//
//}
