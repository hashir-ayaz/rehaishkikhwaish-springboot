package com.SDA.rehaishkikhwaish.repository;

import com.SDA.rehaishkikhwaish.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
    City findByName(String name);
}
