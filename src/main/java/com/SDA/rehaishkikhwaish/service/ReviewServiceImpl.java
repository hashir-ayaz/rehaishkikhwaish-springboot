package com.SDA.rehaishkikhwaish.service;

import com.SDA.rehaishkikhwaish.entity.Review;
import com.SDA.rehaishkikhwaish.repository.DormRepository;
import com.SDA.rehaishkikhwaish.repository.ReviewRepository;
import com.SDA.rehaishkikhwaish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    DormRepository dormRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Review saveReview(Review review, int dormId,int userId){
        Review tempReview = new Review();
        tempReview.setReviewText(review.getReviewText());
        tempReview.setRating(review.getRating());
        tempReview.setDorm(dormRepository.findById(dormId).get());
        tempReview.setUser(userRepository.findById(userId).get());
        return reviewRepository.save(tempReview);

    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }




    public Review updateReview(int id, Review reviewDetails) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setReviewText(reviewDetails.getReviewText());
        review.setRating(reviewDetails.getRating());
        review.setDorm(reviewDetails.getDorm());
        review.setUser(reviewDetails.getUser());

        return reviewRepository.save(review);
    }

    public void deleteReview(int id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        reviewRepository.delete(review);
    }

    @Override
    public void findAllReviews() {

    }

}
