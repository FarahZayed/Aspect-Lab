package com.example.Lab2.Item;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepo extends JpaRepository<itemModel,Integer> {
}
