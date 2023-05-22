package com.example.orderproducer.adapter.controller;

import com.example.orderproducer.application.OrderKafkaProducer;
import com.example.orderproducer.application.dto.OrderRequestDTO;
import com.example.orderproducer.application.repo.OrderRepository;
import com.example.orderproducer.domain.OrderEvent;
import com.example.orderproducer.entity.Orders;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaTopicController {

    private final OrderKafkaProducer orderKafkaProducer;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final OrderRepository orderRepository;

    public KafkaTopicController(OrderKafkaProducer orderKafkaProducer, KafkaTemplate<String, String> kafkaTemplate, OrderRepository orderRepository){
        this.orderKafkaProducer = orderKafkaProducer;
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }
//    @PostMapping("/send")
//    public void sendTopic(@RequestBody OrderRequestDTO request) throws ExecutionException, InterruptedException{
//        orderKafkaProducer.send(request);
//
//    }

    @PostMapping("/send")
    public ResponseEntity<String> sendTopic(@RequestBody OrderRequestDTO request){
        Orders ods = new Orders();
        ods.updateFromDTO(request);
        orderRepository.save(ods);
        String orderId = ods.getOrderNo().toString();
        kafkaTemplate.send(new ProducerRecord<>("orderId",orderId));

        System.out.println("프로듀서가 전송한 order의 PK: "+orderId);

        String paymentPageUrl = "/payment?orderId="+orderId;
        return ResponseEntity.ok(paymentPageUrl);
    }
}
