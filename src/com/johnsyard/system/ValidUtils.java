package com.johnsyard.system;

/**
 * This is validation class
 * Created by xuanzhang on 16/05/2017.
 */
public class ValidUtils {
    private static final double MIN_DEPOSIT_AMOUNT = 10000;
    //check empty
    public static boolean checkEmpty(String input){
        return input.isEmpty();
    }
    //check deposit amount
    public static boolean checkDepositAmount(double amount){ return amount >= MIN_DEPOSIT_AMOUNT; }

}
