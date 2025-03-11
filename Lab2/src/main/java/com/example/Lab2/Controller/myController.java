package com.example.Lab2.Controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Lab2.service.myServices;
import org.springframework.web.bind.annotation.*;

//for json staff
class ItemRequest {
    private String name;

    public String getName() {
        return name;
    }
}

@RestController
@RequestMapping("/items")
public class myController {
    private final myServices itemService;
    @Autowired
    public myController(myServices myService)
    {
        this.itemService = myService;
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable int id) {
        return itemService.getItemById(id);
    }

    @PostMapping("/")
    public String addItem(@RequestBody ItemRequest request) {
        return itemService.addItem(request.getName());
    }


    @PutMapping("/{id}")
    public String updateItem(@PathVariable int id, @RequestBody ItemRequest request) {
        return itemService.updateItem(id, request.getName());
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        return itemService.deleteItem(id);
    }

}