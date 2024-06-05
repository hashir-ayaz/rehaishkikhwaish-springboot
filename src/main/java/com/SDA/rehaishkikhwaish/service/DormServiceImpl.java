package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.Amenity;
import com.SDA.rehaishkikhwaish.entity.City;
import com.SDA.rehaishkikhwaish.entity.Dorm;
import com.SDA.rehaishkikhwaish.entity.User;
import com.SDA.rehaishkikhwaish.repository.AmenityRepository;
import com.SDA.rehaishkikhwaish.repository.CityRepository;
import com.SDA.rehaishkikhwaish.repository.DormRepository;
import com.SDA.rehaishkikhwaish.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class DormServiceImpl implements DormService
{
    private final CityRepository cityRepository;
    DormRepository dormRepository;
    UserRepository userRepository;
    AmenityRepository amenityRepository;
//    @Override
////    public Dorm saveDorm(Dorm dorm, Integer userId) {
////        User tempUser = new User();
////        City tempCity= new City();
////        List<Amenity> tempAmenityList = dorm.getAmenityList();
////
////        if(dorm.getCity()==null) {dorm.setCity(tempCity);}
////        tempUser = userRepository.findById(userId).get();
////        dorm.setUser(tempUser);
////        dorm.setAmenityList(tempAmenityList);
////        return dormRepository.save(dorm);
////
////    }
    public Dorm saveDorm(Long userId, Integer cityId, List<Integer> amenities, String title, String description, String address, BigDecimal pricePerMonth) {
        Optional<User> userOptional = userRepository.findById(Math.toIntExact(userId));
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        User user = userOptional.get();

        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new RuntimeException("City not found with id: " + cityId));
        System.out.println("City ID: " + cityId);
        System.out.println("City: " + city.getName()+ city.getId()+ city.getRegion());

        Dorm dorm = new Dorm();
        dorm.setUser(user);
        dorm.setCity(city);
        dorm.setTitle(title);
        dorm.setDescription(description);
        dorm.setAddress(address);
        dorm.setPricePerMonth(pricePerMonth);

        //loop through amenities , find them using amenityRepository and add them to dorm

        for(Integer amenityId : amenities) {
            System.out.println(amenityId);
            Amenity amenity = amenityRepository.findById(amenityId).orElseThrow(() -> new RuntimeException("Amenity not found with id: " + amenityId));
            dorm.getAmenityList().add(amenity);
        }

        return dormRepository.save(dorm);
    }



    @Override
    public Dorm findDormById(Integer id) {
        return dormRepository.findById(id).get();
    }

    @Override
    public void deleteDorm(Integer dormId) {
        dormRepository.deleteById(dormId);
    }

    @Override
    public List<Dorm> findAllDorms() {
        return dormRepository.findAll();
    }

    public Dorm updateDorm(Integer id, Dorm dormDetails) {
        Dorm existingDorm = dormRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dorm not found with id: " + id));

        existingDorm.setTitle(dormDetails.getTitle());
        existingDorm.setContactNumber(dormDetails.getContactNumber());
        existingDorm.setCity(dormDetails.getCity());
        existingDorm.setDescription(dormDetails.getDescription());
        existingDorm.setPricePerMonth(dormDetails.getPricePerMonth());
        existingDorm.setAmenityList(dormDetails.getAmenityList());
        existingDorm.setAddress(dormDetails.getAddress());

        // Set other properties from dormDetails as needed

        return dormRepository.save(existingDorm);
    }

}
