package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    List<City> findAllCities();
    City findCityById(Integer id);
    City findCityByName(String name);
    City saveCity(City city);
    City updateCity(Integer id, City city);
    void deleteCity(Integer id);
}
