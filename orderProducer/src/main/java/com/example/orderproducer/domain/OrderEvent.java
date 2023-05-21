package com.example.orderproducer.domain;

import lombok.Getter;

@Getter
public class OrderEvent {

    private Long id;
    private String orderName;
    private int count;

    private OrderEvent(){
    }

    public static OrderEvent create(Long id, String orderName, int count, boolean isPurchased){
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.id = id;
        orderEvent.orderName = orderName;
        orderEvent.count = count;
        return orderEvent;
    }
}
