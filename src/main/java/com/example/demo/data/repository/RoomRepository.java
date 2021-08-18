package com.example.demo.data.repository;

import com.example.demo.data.entity.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room, Long> {
}
