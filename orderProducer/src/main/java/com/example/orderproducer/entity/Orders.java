package com.example.orderproducer.entity;

import com.example.orderproducer.application.dto.OrderRequestDTO;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNo;

    private String orderName;
    private int count;

    public void updateFromDTO(OrderRequestDTO dto){
        this.orderName = dto.getOrderName();
        this.count = dto.getCount();
    }
}
