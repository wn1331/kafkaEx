package com.example.orderproducer.application.repo;

import com.example.orderproducer.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,String> {
}
