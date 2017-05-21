package com.johnsyard.system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    //check number
    public static boolean checkValidNumber(String input){
        boolean result = true;
        Pattern pattern = Pattern.compile("^[0-9]+.?[0-9]?");
        Matcher isNum = pattern.matcher(input);
        if( !isNum.matches() ){
            result = false;
        }
        return result;
    }

    //check password
    public static boolean checkPassword(String input){
        boolean result = true;
        //one upper case, one lower case, one number and one special character
        Pattern pattern = Pattern.compile(".*[0-9]+.*");
        Pattern pattern1 = Pattern.compile(".*[a-z]+.*");
        Pattern pattern2 = Pattern.compile(".*[A-Z]+.*");
        Pattern pattern3 = Pattern.compile(".*[!@#$%^&*~_+`=|:;]+.*");
        Matcher isPasswd = pattern.matcher(input);
        Matcher isPasswd1 = pattern1.matcher(input);
        Matcher isPasswd2 = pattern2.matcher(input);
        Matcher isPasswd3 = pattern3.matcher(input);

        boolean one = isPasswd.matches();
        boolean two = isPasswd1.matches();
        boolean three = isPasswd2.matches();
        boolean four = isPasswd3.matches();

        if(!(isPasswd.matches() && isPasswd1.matches() && isPasswd2.matches() &&
                isPasswd3.matches()) || input.length() < 8){
            result = false;
        }
        return result;
    }

    //check PIN
    public static boolean checkPIN(String input){
        boolean result = true;
        //6 digits
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher isNum = pattern.matcher(input);
        if( !isNum.matches() || input.length() != 6){
            result = false;
        }
        return result;
    }
    //check deposit amount
    public static boolean checkDepositAmount(double amount){ return amount >= MIN_DEPOSIT_AMOUNT; }

}
