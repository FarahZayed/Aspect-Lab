package com.example.Lab2.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class myServices {

    public List<itemModel> items = new ArrayList<>();

    private  itemRepo itemRepo = null;
    @Autowired
    public myServices(itemRepo itemRepo){
        this.itemRepo =itemRepo;
    }
    public List<itemModel> getItem() {
        return this.itemRepo.findAll();
    }

    public itemModel addItem (itemDTO newItem){
        itemModel item = new itemModel(newItem.getName(), newItem.getDescription());
        return this.itemRepo.save(item);
    }

    public itemModel findItemById(Integer id){

        return this.itemRepo.findById(id).orElseGet(() -> {
            System.out.println("Item not found with Id: " + id);
            return null;
        });
    }

    public itemModel updateItem(Integer id, itemDTO updatedItem) {
        itemModel existingItem = findItemById(id);
        existingItem.setName(updatedItem.getName());
        existingItem.setDescription(updatedItem.getDescription());
        return this.itemRepo.save(existingItem);
    }

    public void deleteItem(Integer id) {
        if (!itemRepo.existsById(id)) {
            throw new RuntimeException("Item not found with ID: " + id);
        }
        itemRepo.deleteById(id);
    }
}
