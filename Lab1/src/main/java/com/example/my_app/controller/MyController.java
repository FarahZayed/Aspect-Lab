package com.example.my_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.my_app.service.Myservice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class MyController {
    private final Myservice itemService;

    public MyController(Myservice myService) {
        this.itemService = myService;
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable int id) {
        return itemService.getItem(id);
    }

    @PostMapping("/{id}")
    public String addItem(@PathVariable int id, @RequestParam String name) {
        return itemService.addItem(id, name);
    }

    @PutMapping("/{id}")
    public String updateItem(@PathVariable int id, @RequestParam String name) {
        return itemService.updateItem(id, name);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        return itemService.deleteItem(id);
    }

}