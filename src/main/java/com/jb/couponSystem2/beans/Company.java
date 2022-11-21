package com.jb.couponSystem2.beans;
/*

Hila Gannot
11/20/2022 10:57

*/

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COMPANIES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String password;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @Singular
    List<Coupon> coupons;

    public Company(String name, String email, String password, List<Coupon> coupons) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.coupons = coupons;
    }
}
