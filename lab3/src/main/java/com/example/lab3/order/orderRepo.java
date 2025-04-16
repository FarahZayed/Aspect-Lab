package com.example.lab3.order;


import com.example.lab3.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepo extends JpaRepository<Order, Long> {
}