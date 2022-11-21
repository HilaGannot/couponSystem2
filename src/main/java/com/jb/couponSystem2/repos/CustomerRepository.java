package com.jb.couponSystem2.repos;

import com.jb.couponSystem2.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*

Hila Gannot
11/20/2022 11:29

*/
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
