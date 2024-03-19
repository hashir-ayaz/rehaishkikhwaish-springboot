package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.Dorm;
import com.SDA.rehaishkikhwaish.entity.User;
import com.SDA.rehaishkikhwaish.repository.DormRepository;
import com.SDA.rehaishkikhwaish.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service

public class DormServiceImpl implements DormService
{
    DormRepository dormRepository;
    UserRepository userRepository;
    @Override
    public Dorm saveDorm(Dorm dorm, Integer userId) {
        User tempUser = new User();
        tempUser = userRepository.findById(userId).get();
        dorm.setUser(tempUser);
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
        existingDorm.setCities(dormDetails.getCities());
        existingDorm.setDescription(dormDetails.getDescription());
        existingDorm.setPricePerMonth(dormDetails.getPricePerMonth());
        existingDorm.setAmenities(dormDetails.getAmenities());
        // Set other properties from dormDetails as needed

        return dormRepository.save(existingDorm);
    }

}
