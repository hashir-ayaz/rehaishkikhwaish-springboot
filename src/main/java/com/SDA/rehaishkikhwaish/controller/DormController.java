package com.SDA.rehaishkikhwaish.controller;

import com.SDA.rehaishkikhwaish.entity.Amenity;
import com.SDA.rehaishkikhwaish.entity.Dorm;
import com.SDA.rehaishkikhwaish.entity.User;
import com.SDA.rehaishkikhwaish.service.DormService;
import com.SDA.rehaishkikhwaish.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor

@RequestMapping("/dorms")
public class DormController {
    DormService dormService;

    @GetMapping("/all")
    public ResponseEntity<List<Dorm>> getAllDorms() {
        return new ResponseEntity<>(dormService.findAllDorms(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dorm> getDormById(@PathVariable Integer id){
        return new ResponseEntity<>(dormService.findDormById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dorm> deleteDorm(@PathVariable Integer id){
        dormService.deleteDorm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/add/{userId}")
//    public ResponseEntity<Dorm> addDorm(@RequestBody Dorm dorm, @PathVariable Integer userId){
//        return new ResponseEntity<>(dormService.saveDorm(dorm,userId),HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Dorm> updateDorm(@PathVariable Integer id, @RequestBody Dorm dormDetails) {
        Dorm updatedDorm = dormService.updateDorm(id, dormDetails);
        return new ResponseEntity<>(updatedDorm, HttpStatus.OK);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addDorm(
            @PathVariable Long userId,
            @RequestParam("cityId") Integer cityId,
            @RequestParam String amenities,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("address") String address,
            @RequestParam("pricePerMonth") BigDecimal pricePerMonth) {

        // Parse the amenities JSON string to a list of integers
        ObjectMapper objectMapper = new ObjectMapper();
        List<Integer> amenitiesList;
        try {
            amenitiesList = Arrays.asList(objectMapper.readValue(amenities, Integer[].class));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid amenities format");
        }


        dormService.saveDorm(userId, cityId, amenitiesList,title, description, address, pricePerMonth);

        return ResponseEntity.ok().body("Dorm added successfully");
    }

}



