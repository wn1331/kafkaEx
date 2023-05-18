package com.example.orderproducer.application.dto;

import com.example.orderproducer.entity.Orders;
import lombok.Data;

@Data
public class OrderRequestDTO {
    private Long id;
    private String orderName;
    private int count;

    private OrderRequestDTO(){

    }
}
