package com.example.lab3.order;

import com.example.lab3.customer.customer;
import com.example.lab3.customer.CustomerRepo;
import com.example.lab3.order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private orderRepo orderRepository;

    @Autowired
    private CustomerRepo customerRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/customer/{customerId}")
    public Order createOrder(@PathVariable Long customerId, @RequestBody Order order) {
        customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        order.setcustomer(customer);
        return orderRepository.save(order);
    }

    @PutMapping("/{orderId}")
    public Order updateOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        order.setItem(updatedOrder.getItem());
        order.setQuantity(updatedOrder.getQuantity());

        return orderRepository.save(order);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));
        orderRepository.delete(order);
        return "Order with ID " + orderId + " has been deleted.";
    }
}
