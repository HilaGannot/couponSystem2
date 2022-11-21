package com.jb.couponSystem2.repos;

import com.jb.couponSystem2.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*

Hila Gannot
11/20/2022 11:28

*/
@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    @Query(value = "INSERT INTO `couponsystem2-151`.`customers_coupons` (`customer_id`, `coupons_id`) VALUES (?, ?);", nativeQuery = true)
    @Transactional
    @Modifying
    void addCouponPurchase(int customerId, int couponId);


    @Query(value = "DELETE FROM `couponsystem2-151`.`customers_coupons` WHERE (`customer_id` = ?) and (`coupons_id` = ?);", nativeQuery = true)
    @Transactional
    @Modifying
    void deleteCouponPurchase(int customerId, int couponId);

}
