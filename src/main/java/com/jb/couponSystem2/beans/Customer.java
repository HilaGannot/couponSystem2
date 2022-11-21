package com.jb.couponSystem2.beans;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*

Hila Gannot
11/20/2022 11:18

*/
@Entity
@Table(name = "CUSTOMERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 40)
    private String firstName;
    @Column(nullable = false,length = 40)
    private String lastName;
    @Column(nullable = false,length = 40)
    private String email;
    @Column(nullable = false,length = 20)
    private String password;
    @ManyToMany (fetch = FetchType.EAGER)
    @Singular
    private List<Coupon> coupons = new ArrayList<>();
}
