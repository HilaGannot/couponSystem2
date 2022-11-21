package com.jb.couponSystem2.clr.on.tests;
/*

Hila Gannot
11/20/2022 2:10

*/

import com.jb.couponSystem2.beans.Company;
import com.jb.couponSystem2.beans.Coupon;
import com.jb.couponSystem2.beans.Customer;
import com.jb.couponSystem2.exaption.CouponsSystemException;
import com.jb.couponSystem2.login.ClientType;
import com.jb.couponSystem2.login.LoginManager;
import com.jb.couponSystem2.service.AdminService;
import com.jb.couponSystem2.utils.FactoryMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class AdminServiceTest implements CommandLineRunner {

    @Autowired
    private AdminService adminService;
    @Autowired
    private FactoryMethod factoryMethod;
    @Autowired

    private LoginManager loginManager;

    private List<Coupon> couponList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        login();
        addCompany();
        updateCompany();
        deleteCompany();
        getAllCompanies();
        getOneCompany();
        addCustomer();
        updateCustomer();
        deleteCustomer();
        getAllCustomers();
        getOneCustomer();
    }


    private void login() {
        System.out.println();
        try {
            adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Administartor);
            System.out.println("Admin successfully logged in");
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        try {
            adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Administartor);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            adminService = (AdminService) loginManager.login("admin@admin.com", "admin", ClientType.Administartor);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************************************************************\n");
    }

    private void addCompany() {
        Company company = factoryMethod.newCompany("blabla");
        for (int i = 0; i < 4; i++) {
            couponList.add(factoryMethod.newCoupon(company));
        }
        company.setCoupons(couponList);

        couponList = new ArrayList<>();
        Company company1 = factoryMethod.newCompany("blabla");
        for (int i = 0; i < 4; i++) {
            couponList.add(factoryMethod.newCoupon(company1));
        }
        company1.setCoupons(couponList);

        //add company
        try {
            adminService.addCompany(company);
            System.out.println("The company has been successfully added");
            getAllCompanies();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        //add customer throw exception

        try {
            adminService.addCompany(company1);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        company.setEmail(company1.getEmail());

        try {
            adminService.addCompany(company);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("************************************************************\n");
    }

    private void updateCompany() {
        try {
            Company company = adminService.getOneCompany(1);
            company.setEmail("1111");
            adminService.updateCompany(1, company);
            System.out.println("The company has been updated successfully");
            getAllCompanies();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            Company company = adminService.getOneCompany(1);
            company.setName("1111");
            adminService.updateCompany(1, company);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            Company company = adminService.getOneCompany(1);
            company.setEmail("1111");
            adminService.updateCompany(15, company);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("************************************************************\n");
    }

    private void deleteCompany() {
        try {
            adminService.deleteCompany(6);
            System.out.println("The company has been successfully deleted");
            getAllCompanies();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            adminService.deleteCompany(6);
            getAllCompanies();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************************************************************\n");
    }

    private void getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        companies = adminService.getAllCompanies();
        System.out.println("ALL COMPANIES:");
        companies.forEach(System.out::println);
        System.out.println();
    }

    private void getOneCompany() {
        System.out.println("************************************************************\n");
        try {
            System.out.println("GET ONE COMPANY:");
            System.out.println(adminService.getOneCompany(2));
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            System.out.println(adminService.getOneCompany(6));
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************************************************************\n");
    }

    private void addCustomer() {

        Customer customer = factoryMethod.newCustomer("yallabalagan", couponList);


        Customer customer1 = factoryMethod.newCustomer("yallabalagan", couponList);

        //add customer
        try {
            adminService.addCustomer(customer);
            System.out.println("Customer successfully added");
            getAllCustomers();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        //add customer throw exception

        try {
            adminService.addCustomer(customer1);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************************************************************\n");
    }

    private void updateCustomer() {
        try {
            Customer customer = adminService.getOneCustomer(2);
            customer.setEmail("1111");
            adminService.updateCustomer(2, customer);
            System.out.println("The customer has been updated successfully");
            getAllCustomers();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            Customer customer = adminService.getOneCustomer(2);
            customer.setId(3);
            adminService.updateCustomer(2, customer);
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("************************************************************\n");
    }

    private void deleteCustomer() {
        try {
            adminService.deleteCustomer(6);
            System.out.println("The customer has been successfully deleted");
            getAllCustomers();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        try {
            adminService.deleteCustomer(6);
            getAllCustomers();
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("************************************************************\n");
    }

    private void getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers = adminService.getAllCustomer();

        System.out.println("ALL CUSTOMERS:");
        customers.forEach(System.out::println);
        System.out.println();
    }

    private void getOneCustomer() {
        System.out.println("************************************************************\n");
        try {
            System.out.println("GET ONE CUSTOMER:");
            System.out.println(adminService.getOneCustomer(3));
        } catch (CouponsSystemException e) {
            System.out.println(e.getMessage());
        }
    }

}
