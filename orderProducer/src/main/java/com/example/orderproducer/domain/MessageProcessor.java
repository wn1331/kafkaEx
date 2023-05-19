package com.example.orderproducer.domain;

public class MessageProcessor {
    public void processMessage(String message){
        System.out.println("컨슈머가 받은 메시지: " + message);
    }
}
