package com.jb.couponSystem2.clr.on;
/*

Hila Gannot
11/20/2022 11:39

*/

import com.jb.couponSystem2.beans.CATEGORY;
import com.jb.couponSystem2.beans.Company;
import com.jb.couponSystem2.beans.Coupon;
import com.jb.couponSystem2.beans.Customer;
import com.jb.couponSystem2.repos.CompanyRepository;
import com.jb.couponSystem2.repos.CouponRepository;
import com.jb.couponSystem2.repos.CustomerRepository;
import com.jb.couponSystem2.service.ClientService;
import com.jb.couponSystem2.utils.FactoryMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Component
@Order(1)
public class Init implements CommandLineRunner {

    private static final int NUM_OF_COUPONS = 10;
    private static final int NUM_OF_CUSTOMERS = 5;
    private static final int NUM_OF_COMPANIES = 5;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CouponRepository couponRepository;


    @Override
    public void run(String... args) throws Exception {


        List<Company> companyList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        FactoryMethod factoryMethod = new FactoryMethod();
        List<Coupon> couponList = new ArrayList<>();

        for (int i = 0; i < NUM_OF_COMPANIES; i++) {
            Company company = factoryMethod.newCompany("aa"+i+"bb");
            companyList.add(company);
            couponList = new ArrayList<>();
            for (int j = 0; j < NUM_OF_COUPONS; j++) {
                couponList.add(factoryMethod.newCoupon(company));

            }
            company.setCoupons(couponList);
            customerList.add(factoryMethod.newCustomer("zz"+i+"yyy",couponList));

        }
        customerRepository.saveAll(customerList);
       // companyRepository.saveAll(companyList);
        couponList = couponRepository.findAll();
        for (Coupon c:couponList) {
            couponRepository.addCouponPurchase(1,c.getId());
        }


    }
}
