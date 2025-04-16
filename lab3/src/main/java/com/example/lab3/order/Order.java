package com.example.lab3.order;

import com.example.lab3.customer.customer;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customer customer;

    public Order() {}

    public Order(String item, int quantity, customer customer) {
        this.item = item;
        this.quantity = quantity;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public customer getcustomer() {
        return customer;
    }

    public void setcustomer(customer customer) {
        this.customer = customer;
    }
}

