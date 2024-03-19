package com.SDA.rehaishkikhwaish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "review_text", length = 600)
    private String reviewText;
    @Column(name = "rating")
    private int rating;
    @Column(name = "dorm_id")
    private Dorm dorm;
    @Column(name = "user_id")
    private User user;

}
