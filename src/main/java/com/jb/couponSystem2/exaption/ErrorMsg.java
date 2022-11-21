package com.jb.couponSystem2.exaption;
/*

Hila Gannot
11/20/2022 1:37

*/

public enum ErrorMsg {

    COMPANY_NAME_EXIST("can't add new company with the same name like exist company"),
    COMPANY_EMAIL_EXIST("can't add new company with the same email like exist company"),
    CANT_CHANGE_ID_COMPANY("can't change the company ID"),
    CANT_CHANGE_NAME("can't change the company name"),
    CUSTOMER_EMAIL_EXIST("can't add new customer with the same email like exist customer"),
    CANT_CHANGE_ID_CUSTOMER("can't change the customer ID"),
    COUPON_EXIST("can't add coupon that exist in the company"),
    CANT_CHANGE_ID_COUPON("can't change the coupon ID"),
    CANT_CHANGE_COMPANY_ID_IN_COUPON("can't change the company id in coupon"),
    CUSTOMER_ID_EXIST("this customer id isn't exist"),
    ID_NOT_EXISTS("this id is not exists"),
    COMPANY_ID_EXIST("this company id isn't exist"),
    COUPON_ID_EXIST("this coupon id isn't exist"),
    LOG_IN("this email or password is not valid"),
    IN_STOCK("the coupon is not in stock"),
    PURCHASE_BEFORE("the coupon is purchase before"),
    COUPON_NOT_EXIST("the coupon is not exist"),
    IS_VALID("the coupon is expired");

    private String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

