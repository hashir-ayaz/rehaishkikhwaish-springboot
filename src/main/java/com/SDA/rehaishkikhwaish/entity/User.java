package com.SDA.rehaishkikhwaish.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private Integer userId;
    @Column(name="user_name")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="created_at")
    private String createdAt;
    @Column(name="updated_at")
    private String updatedAt;
    @Column(name="date_of_birth")
    private String dateOfBirth;

    public User(String username, Integer userId, String email, String password, String createdAt, String updated_at, String dateOfBirth) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updated_at;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }


}
