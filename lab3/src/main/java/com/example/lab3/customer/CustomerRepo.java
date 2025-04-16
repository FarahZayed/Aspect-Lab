package com.example.lab3.customer;


import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepo extends JpaRepository<customer, Long> {
}