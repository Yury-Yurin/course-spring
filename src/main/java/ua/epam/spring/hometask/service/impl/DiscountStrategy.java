package ua.epam.spring.hometask.service.impl;

/**
 * Created by yury on 7/25/16.
 */
public class DiscountStrategy {



    public static double calcDiscount(String strategy) {
        switch(strategy) {
            case "birthday" :
                return 0.05;
            case "10tickets" :
                return 0.5;
            case "eventOnHolidays" :
                return 0.3;
            default:
                break;
        }
        return 0.0;
    }
}
