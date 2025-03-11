package com.example.Lab2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class myServices {
    private Map<Integer, String> items = new HashMap<>();
    private AtomicInteger idGenerator = new AtomicInteger(1);

    public String getItemById(int id) {
        return items.getOrDefault(id, "Item not found");
    }

    public String addItem(String name) {
        int id = idGenerator.getAndIncrement();
        items.put(id, name);
        return "Item added successfully with ID: " + id;
    }

    public String updateItem(int id, String name) {
        if (items.containsKey(id)) {
            items.put(id, name);
            return "Item updated successfully";
        }
        return "Item not found";
    }

    public String deleteItem(int id) {
        if (items.remove(id) != null) {
            return "Item deleted successfully";
        }
        return "Item not found";
    }
}
