package com.example.Lab2.Item;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.Lab2.Item.itemModel;
import com.example.Lab2.Item.myServices;

import java.util.List;

@RestController
@RequestMapping(path = "/items")
public class myController {
    private final myServices itemService;
    @Autowired
    public myController(myServices myService)
    {
        this.itemService = myService;
    }



    @GetMapping()
    public List<itemModel> getItem() {
        return itemService.getItem();
    }

    @PostMapping()
    public itemModel addItem(@RequestBody itemDTO newItem){
        return this.itemService.addItem(newItem);
    }

    @GetMapping("/{id}")
    public  itemModel gfindItemById(@PathVariable Integer id){
        return this.itemService.findItemById(id);
    }

    @PutMapping("/{id}")
    public itemModel updateItem(@PathVariable Integer id, @RequestBody itemDTO updatedItem) {
        return this.itemService.updateItem(id, updatedItem);
    }


    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Integer id) {
        this.itemService.deleteItem(id);
        return "Item with ID " + id + " has been deleted.";
    }

}
