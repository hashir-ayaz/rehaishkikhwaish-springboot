package com.SDA.rehaishkikhwaish.repository;

import com.SDA.rehaishkikhwaish.entity.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DormRepository extends JpaRepository<Dorm, Integer> {
}
