package com.SDA.rehaishkikhwaish.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dorms")
public class Dorm implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @ManyToOne(optional = true , cascade = CascadeType.PERSIST)
    @JoinColumn(name = "city_id", nullable = false, referencedColumnName = "id")
    private City city;

    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "price_per_month", precision = 10, scale = 2)
    private BigDecimal pricePerMonth;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dorm_amenities",
            joinColumns = @JoinColumn(name = "dorm_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<Amenity> amenityList = new ArrayList<>();

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "dorm_images",
//            joinColumns = @JoinColumn(name = "dorm_id"),
//            inverseJoinColumns = @JoinColumn(name = "image_id")
//    )
//    private List<MultipartFile> images;
}
