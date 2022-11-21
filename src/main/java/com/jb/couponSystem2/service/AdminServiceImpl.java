package com.jb.couponSystem2.service;

import com.jb.couponSystem2.beans.Company;
import com.jb.couponSystem2.beans.Customer;
import com.jb.couponSystem2.exaption.CouponsSystemException;
import com.jb.couponSystem2.exaption.ErrorMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/*

Hila Gannot
11/20/2022 1:28

*/
@Service
public class AdminServiceImpl extends ClientService implements AdminService {


    @Value("${ADMIN_EMAIL}")
    private static final String ADMIN_EMAIL = "admin@admin.com";
    @Value("${ADMIN_PASSWORD}")
    private static final String ADMIN_PASSWORD = "admin";


    @Override
    public void addCompany(Company company) throws CouponsSystemException {
        int companyId = company.getId();
        if (companyRepository.existsById(companyId)) {
            throw new CouponsSystemException(ErrorMsg.COMPANY_ID_EXIST);
        }
        if (companyRepository.existsByName(company.getName())) {
            throw new CouponsSystemException(ErrorMsg.COMPANY_NAME_EXIST);
        }
        if (companyRepository.existsByEmail(company.getEmail())) {
            throw new CouponsSystemException(ErrorMsg.COMPANY_EMAIL_EXIST);
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(int companyId, Company company) throws CouponsSystemException {
        if (companyId != company.getId()) {
            throw new CouponsSystemException(ErrorMsg.CANT_CHANGE_ID_COMPANY);
        }

        if (!companyRepository.existsById(companyId)) {
            throw new CouponsSystemException(ErrorMsg.COMPANY_ID_EXIST);
        }

        Company existCompany = companyRepository.findById(companyId).orElseThrow(() -> new CouponsSystemException(ErrorMsg.ID_NOT_EXISTS));

        if (!existCompany.getName().equals(company.getName())) {
            throw new CouponsSystemException(ErrorMsg.CANT_CHANGE_NAME);
        }

        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws CouponsSystemException {
        if (!companyRepository.existsById(companyId)) {
            throw new CouponsSystemException(ErrorMsg.COMPANY_ID_EXIST);
        }
        companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOneCompany(int companyId) throws CouponsSystemException {
        return companyRepository.findById(companyId).orElseThrow(() -> new CouponsSystemException(ErrorMsg.ID_NOT_EXISTS));
    }

    @Override
    public void addCustomer(Customer customer) throws CouponsSystemException {
        int customerId = customer.getId();
        if (customerRepository.existsById(customerId)) {
            throw new CouponsSystemException(ErrorMsg.CUSTOMER_ID_EXIST);
        }

        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new CouponsSystemException(ErrorMsg.CUSTOMER_EMAIL_EXIST);
        }
        System.out.println(customer);
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponsSystemException {
        if (customerId != customer.getId()) {
            throw new CouponsSystemException(ErrorMsg.CANT_CHANGE_ID_CUSTOMER);
        }
        if (!customerRepository.existsById(customerId)) {
            throw new CouponsSystemException(ErrorMsg.CUSTOMER_ID_EXIST);
        }

        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponsSystemException {
        if (!customerRepository.existsById(customerId)) {
            throw new CouponsSystemException(ErrorMsg.ID_NOT_EXISTS);
        }
        customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getOneCustomer(int customerId) throws CouponsSystemException {
        return customerRepository.findById(customerId).orElseThrow(() -> new CouponsSystemException(ErrorMsg.ID_NOT_EXISTS));
    }

    @Override
    public boolean login(String email, String password) throws CouponsSystemException {
        if ((!email.equalsIgnoreCase(ADMIN_EMAIL)) || (!password.equals(ADMIN_PASSWORD))) {
            throw new CouponsSystemException(ErrorMsg.LOG_IN);
        }
        System.out.println(companyRepository);
        return true;
    }
}
