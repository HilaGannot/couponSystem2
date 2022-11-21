package com.jb.couponSystem2.utils;
/*

Hila Gannot
11/20/2022 11:42

*/

import com.jb.couponSystem2.beans.CATEGORY;
import com.jb.couponSystem2.beans.Company;
import com.jb.couponSystem2.beans.Coupon;
import com.jb.couponSystem2.beans.Customer;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class FactoryMethod {

    private int randInt = (int) (Math.random()*100+100);
    private double randDouble = (Math.random()*100+100);
    private Date starDate = Date.valueOf(LocalDate.now());
    private Date endDate = Date.valueOf(LocalDate.now().plusWeeks(randInt-50));

    public Coupon newCoupon(Company company){
        return Coupon.builder()
                .amount(randInt)
                .category(CATEGORY.randCategory())
                .description("aaa")
                .startDate(starDate)
                .endDate(endDate)
                .image("bbb")
                .title("ccc")
                .price(randDouble)
                .company(company)
                .build();
    }

    public Customer newCustomer(String stringToAll, List<Coupon> coupons){
        return Customer.builder()
                .firstName(stringToAll)
                .lastName("last name"+stringToAll)
                .email(stringToAll+"@gmail.com")
                .password(stringToAll+"1234")
                .coupons(coupons)
                .build();
    }

    public Company newCompany(String stringToAll){
        return Company.builder()
                .name(stringToAll)
                .email(stringToAll+"@gmail.com")
                .password("1234"+stringToAll)
                .build();
    }
}
