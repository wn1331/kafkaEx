package com.example.orderproducer.adapter.controller;

import com.example.orderproducer.application.OrderKafkaProducer;
import com.example.orderproducer.application.dto.OrderRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafka")
public class KafkaTopicController {

    private final OrderKafkaProducer orderKafkaProducer;

    public KafkaTopicController(OrderKafkaProducer orderKafkaProducer){
        this.orderKafkaProducer = orderKafkaProducer;
    }
    @PostMapping("/send")
    public void sendTopic(@RequestBody OrderRequestDTO request) throws ExecutionException, InterruptedException{
        orderKafkaProducer.send(request);
    }

}
