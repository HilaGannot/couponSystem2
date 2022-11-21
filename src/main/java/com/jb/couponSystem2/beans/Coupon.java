package com.jb.couponSystem2.beans;
/*

Hila Gannot
11/20/2022 

*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "COUPONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CATEGORY category;
    @Column(nullable = false, length = 40)
    private String title;
    @Column(nullable = false, length = 50)
    private String description;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private int amount;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false, length = 40)
    private String image;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Company company;


    public Coupon(CATEGORY category, String title, String description, Date startDate, Date endDate, int amount, double price, String image) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }
}
