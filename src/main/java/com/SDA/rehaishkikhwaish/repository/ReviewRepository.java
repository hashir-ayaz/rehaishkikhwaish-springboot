 package com.SDA.rehaishkikhwaish.repository;

 import com.SDA.rehaishkikhwaish.entity.Review;
 import org.springframework.data.jpa.repository.JpaRepository;

 import java.util.List;

 public interface ReviewRepository extends JpaRepository<Review, Integer>{
     List<Review> findByDormId(int dormId);
 }
