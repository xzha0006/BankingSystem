package com.johnsyard.system;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the home loan account
 * Created by xuanzhang on 16/05/2017.
 */
public class CreditAccount extends Account {
    private final double CREDIT_AMOUNT = 1000;

    private String startDate;
    private String endDate;
    private double loanOfLastMonth;
    private double dailyLimitation;
//    private String lastDueDate;
    //constructor
    public CreditAccount(){
        super();
        super.setType("credit");
        this.loanOfLastMonth = 0;
    }

//    public double getMonthlyLoan(){
//        return this.getBalance() / TERM_YEAR / 12 * (1 + MONTHLY_INTEREST);
//    }


    public double getLoanOfLastMonth() {
        return loanOfLastMonth;
    }

    public void setLoanOfLastMonth(double loanOfLastMonth) {
        this.loanOfLastMonth = loanOfLastMonth;
    }

    public double getDailyLimitation() {
        return dailyLimitation;
    }

    public void setDailyLimitation(double dailyLimitation) {
        this.dailyLimitation = dailyLimitation;
    }
}
