package com.SDA.rehaishkikhwaish.controller;

import com.SDA.rehaishkikhwaish.entity.Review;
import com.SDA.rehaishkikhwaish.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    // Create a new review
    @PostMapping("/create/{dormId}/{userId}")
    public ResponseEntity<Review> createReview(@RequestBody Review review, @PathVariable int dormId, @PathVariable int userId) {
        Review savedReview = reviewService.saveReview(review, dormId,userId);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // Get all reviews
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }




    // Delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
