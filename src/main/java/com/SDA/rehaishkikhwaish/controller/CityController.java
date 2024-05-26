package com.SDA.rehaishkikhwaish.controller;

import com.SDA.rehaishkikhwaish.entity.City;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SDA.rehaishkikhwaish.service.CityService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cities")
public class CityController {
    CityService cityService;

    // Create operation
    @PostMapping("/add")
    public ResponseEntity<City> addCity(@RequestBody City city){
        City newCity = cityService.saveCity(city);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }

    // Read operation
    @GetMapping("/all")
    public ResponseEntity<List<City>> getAllCities(){
        List<City> cities = cityService.findAllCities();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Integer id){
        City city = cityService.findCityById(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    // Update operation
    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Integer id, @RequestBody City city){
        City updatedCity = cityService.updateCity(id, city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable Integer id){
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
