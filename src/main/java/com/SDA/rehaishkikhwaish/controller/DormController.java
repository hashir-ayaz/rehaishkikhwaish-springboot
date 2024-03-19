package com.SDA.rehaishkikhwaish.controller;

import com.SDA.rehaishkikhwaish.entity.Dorm;
import com.SDA.rehaishkikhwaish.service.DormService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add/{userId}")
    public ResponseEntity<Dorm> addDorm(@RequestBody Dorm dorm, @PathVariable Integer userId){
        return new ResponseEntity<>(dormService.saveDorm(dorm,userId),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dorm> updateDorm(@PathVariable Integer id, @RequestBody Dorm dormDetails) {
        Dorm updatedDorm = dormService.updateDorm(id, dormDetails);
        return new ResponseEntity<>(updatedDorm, HttpStatus.OK);
    }

}



