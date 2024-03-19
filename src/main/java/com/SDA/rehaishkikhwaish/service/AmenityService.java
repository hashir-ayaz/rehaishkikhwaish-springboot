package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.Amenity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface AmenityService {
    Optional findAmenityById (Integer id );
    List<Amenity> findAllAmenities();
    void deleteAmenity(Integer id);


}
