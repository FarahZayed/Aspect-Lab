package com.example.Lab2.Item;


import jakarta.persistence.*;

@Entity
@Table(name="items")
public class itemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    private String description;

    public itemModel(){}


    public itemModel(Integer id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }

    public itemModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
