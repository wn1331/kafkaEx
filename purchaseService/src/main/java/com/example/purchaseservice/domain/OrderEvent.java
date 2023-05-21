package com.example.purchaseservice.domain;

import lombok.Getter;

@Getter
public class OrderEvent {

    private Long id;
    private String orderName;
    private int count;

    public OrderEvent() {
    }
}
