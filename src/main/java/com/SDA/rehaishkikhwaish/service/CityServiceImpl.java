package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.City;
import com.SDA.rehaishkikhwaish.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City findCityById(Integer id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public City saveCity(City city) {
        return null;
    }

    @Override
    public City updateCity(Integer id, City city) {
        return null;
    }

    @Override
    public void deleteCity(Integer id) {

    }

}