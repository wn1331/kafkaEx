package com.example.orderproducer.application;

import com.example.orderproducer.application.dto.OrderRequestDTO;
import com.example.orderproducer.application.repo.OrderRepository;
import com.example.orderproducer.domain.OrderEvent;
import com.example.orderproducer.entity.Orders;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;

@Service
public class OrderKafkaProducer{
    private static final String TOPIC = "order";

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;


    private final OrderRepository orderRepository;

    public OrderKafkaProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate, OrderRepository orderRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void send(OrderRequestDTO dto) throws ExecutionException, InterruptedException {
        //db에연결. insert(id값 generate) 하고 event로 패스
        Orders ods = new Orders();
        ods.updateFromDTO(dto);
        orderRepository.save(ods);
        OrderEvent event = OrderEvent.create(ods.getOrderNo(), ods.getOrderName(), ods.getCount(),ods.isPurchased());
//        kafkaTemplate.send(TOPIC, event.getId().toString(), event).get();
        kafkaTemplate.send(new ProducerRecord<>(TOPIC,event));
        System.out.println("프로듀서가 전송한 주문 ID : "+event.getId());
    }

}
