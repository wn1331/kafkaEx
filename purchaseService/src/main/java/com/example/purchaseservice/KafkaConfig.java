package com.example.purchaseservice;

import com.example.purchaseservice.domain.MessageProcessor;
import com.example.purchaseservice.domain.OrderProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public MessageProcessor messageProcessor(){
        return new MessageProcessor();
    }

    @Bean
    public OrderProcessor orderProcessor(){
        return new OrderProcessor();
    }
}