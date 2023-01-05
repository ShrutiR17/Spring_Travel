package com.example.travellist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Travelentity, String>{
    List<Travelentity> getByName(String name);
}
