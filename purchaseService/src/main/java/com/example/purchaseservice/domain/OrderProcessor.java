package com.example.purchaseservice.domain;

public class OrderProcessor {
    public void processOrder(String record){
        System.out.println("컨슈머가 가져온 주문 ID : "+record);
    }
}
