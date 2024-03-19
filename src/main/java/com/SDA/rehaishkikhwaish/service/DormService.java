package com.SDA.rehaishkikhwaish.service;
import com.SDA.rehaishkikhwaish.entity.Dorm;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DormService {
    Dorm saveDorm(Dorm dorm, Integer userId);
    Dorm findDormById(Integer id);
    void deleteDorm(Integer dormId);
    List<Dorm> findAllDorms();

    Dorm updateDorm(Integer id, Dorm dormDetails);

}
