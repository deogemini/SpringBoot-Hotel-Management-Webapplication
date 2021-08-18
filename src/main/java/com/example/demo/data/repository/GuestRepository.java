package com.example.demo.data.repository;

import com.example.demo.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

public interface GuestRepository extends CrudRepository<Guest, Long> {
}
