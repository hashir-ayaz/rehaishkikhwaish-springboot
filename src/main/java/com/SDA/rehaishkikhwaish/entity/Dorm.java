package com.SDA.rehaishkikhwaish.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dorms")
public class Dorm {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "contact_number", length = 15)
    private String contactNumber;

    @Column(name = "cities")
    private int cities;

    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "description", length = 600)
    private String description;

    @Column(name = "price_per_month", precision = 10, scale = 0)
    private BigDecimal pricePerMonth;

    @Column(name = "amenities")
    private int amenities;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dorm_amenities", joinColumns = @JoinColumn(name = "dorm_id"), inverseJoinColumns = @JoinColumn(name = "amenity_id"))
    private List<Amenity> amenityList;
}
