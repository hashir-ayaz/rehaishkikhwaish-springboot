package com.SDA.rehaishkikhwaish.service;

import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    public void saveReview();
    public void findReviewById();
    public void deleteReview();
    public void findAllReviews();
    public void updateReview();

}
