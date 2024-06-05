package com.SDA.rehaishkikhwaish.service;
import com.SDA.rehaishkikhwaish.entity.Dorm;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public interface DormService {
    Dorm saveDorm(Long userId, Integer cityId, List<Integer> amenities, String title, String description, String address, BigDecimal pricePerMonth);
    Dorm findDormById(Integer id);
    void deleteDorm(Integer dormId);
    List<Dorm> findAllDorms();

    Dorm updateDorm(Integer id, Dorm dormDetails);

}
