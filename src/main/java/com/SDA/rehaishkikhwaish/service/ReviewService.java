package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public Review saveReview(Review review, int dormId,int userId);

    public void deleteReview(int id);
    public void findAllReviews();
    public Review updateReview(int id, Review reviewDetails);

    List<Review> getAllReviews();
}
