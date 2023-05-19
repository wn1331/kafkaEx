package com.example.orderproducer;

import com.example.orderproducer.domain.MessageProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public MessageProcessor messageProcessor(){
        return new MessageProcessor();
    }
}
