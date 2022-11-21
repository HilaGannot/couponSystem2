package com.jb.couponSystem2.exaption;
/*

Hila Gannot
11/20/2022 1:36

*/


public class CouponsSystemException extends Exception{

    public CouponsSystemException(ErrorMsg message) {
        super(message.getMsg());
    }
}
