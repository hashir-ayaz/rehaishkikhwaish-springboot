package com.SDA.rehaishkikhwaish.controller;

import com.SDA.rehaishkikhwaish.entity.Amenity;
import com.SDA.rehaishkikhwaish.entity.Dorm;
import com.SDA.rehaishkikhwaish.service.AmenityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/amenities")
public class AmenityController {
    AmenityService amenityService;

    @GetMapping("/all")
    public ResponseEntity<List<Amenity>> getAllAmenities() {
        return new ResponseEntity<>(amenityService.findAllAmenities(), HttpStatus.OK);
    }


}
