package com.SDA.rehaishkikhwaish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "amenity")
public class Amenity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(nullable = false, name = "name")
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "amenityList")
    private List<Dorm> dormList;
}
