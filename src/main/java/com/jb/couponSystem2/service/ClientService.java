package com.jb.couponSystem2.service;
/*

Hila Gannot
11/20/2022 1:23

*/

import com.jb.couponSystem2.exaption.CouponsSystemException;
import com.jb.couponSystem2.repos.CompanyRepository;
import com.jb.couponSystem2.repos.CouponRepository;
import com.jb.couponSystem2.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CouponRepository couponRepository;

    public abstract boolean login(String email, String password) throws CouponsSystemException;
}
