package com.jb.couponSystem2.service;
/*

Hila Gannot
11/20/2022 1:11

*/

import com.jb.couponSystem2.beans.Company;
import com.jb.couponSystem2.beans.Customer;
import com.jb.couponSystem2.exaption.CouponsSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    void addCompany(Company company) throws CouponsSystemException;
    void updateCompany(int companyId ,Company company) throws CouponsSystemException;
    void deleteCompany(int companyId) throws CouponsSystemException;
    List<Company> getAllCompanies();
    Company getOneCompany(int companyId) throws CouponsSystemException;

    void addCustomer(Customer customer) throws CouponsSystemException;
    void updateCustomer(int customerId ,Customer customer) throws CouponsSystemException;
    void deleteCustomer(int customerId) throws CouponsSystemException;
    List<Customer> getAllCustomer();
    Customer getOneCustomer(int customerId) throws CouponsSystemException;
}
