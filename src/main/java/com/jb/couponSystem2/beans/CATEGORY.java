package com.jb.couponSystem2.beans;
/*

Hila Gannot
11/20/2022 

*/

public enum CATEGORY {
    FOOD,
    ELECTRICITY,
    RESTAURANT,
    VACATION;

    public static CATEGORY randCategory(){
        int randNum = (int) (Math.random()*CATEGORY.values().length);
        return CATEGORY.values()[randNum];
    }
}
