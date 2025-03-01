package com.example.my_app.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class Myservice {
    private Map<Integer, String> items = new HashMap<>();

    public String getItem(int id) {
        return items.getOrDefault(id, "Item not found");
    }

    public String addItem(int id, String name) {
        items.put(id, name);
        return "Item added successfully";
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
