package com.jb.couponSystem2;

import com.jb.couponSystem2.exaption.CouponsSystemException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jb.couponSystem2"},
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ,
				pattern = "com.jb.couponSystem2.clr.off.tests.*"))
public class CouponSystem2Application {

	public static void main(String[] args) throws CouponsSystemException {
		SpringApplication.run(CouponSystem2Application.class, args);
	}
}
