package com.SDA.rehaishkikhwaish.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usersss")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdated_at() {
        return updatedAt;
    }

    public void setUpdated_at(String updated_at) {
        this.updatedAt = updated_at;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public User(Integer userId, String email, String password, String createdAt, String updated_at, String dateOfBirth) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updated_at;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }

}
