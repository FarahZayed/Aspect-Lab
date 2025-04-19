package com.example.Lab4.room;

import com.example.Lab4.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumber(String roomNumber);
    // Add other custom query methods if needed
}