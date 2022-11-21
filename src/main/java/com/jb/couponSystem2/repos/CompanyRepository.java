package com.jb.couponSystem2.repos;
/*

Hila Gannot
11/20/2022 11:24

*/

import com.jb.couponSystem2.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

    boolean existsByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
    boolean existsByName(String name);

}
