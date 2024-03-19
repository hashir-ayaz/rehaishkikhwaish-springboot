package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.Amenity;
import com.SDA.rehaishkikhwaish.repository.AmenityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AmenityServiceImpl implements AmenityService{
    AmenityRepository amenityRepository;


    @Override
    public Optional findAmenityById(Integer id) {
        return amenityRepository.findById(id);
    }

    @Override
    public List<Amenity> findAllAmenities() {
        return amenityRepository.findAll();
    }

    @Override
    public void deleteAmenity(Integer id) {
        amenityRepository.deleteById(id);
    }
}
