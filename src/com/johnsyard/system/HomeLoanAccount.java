package com.johnsyard.system;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the home loan account
 * Created by xuanzhang on 16/05/2017.
 */
public class HomeLoanAccount extends Account {
    private final int TERM_YEAR = 30;
    private final double MONTHLY_INTEREST = 0.05;

    private String startDate;
    private String endDate;
    private String suburb;
    private double loanAmount;
    private double monthlyLoan;

    //constructor
    public HomeLoanAccount(){
        super();
        super.setType("homeLoan");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = sdf.format(new Date());
    }

    //home loan deposit
    @Override
    public void deposit(double amount){
        if(amount >= monthlyLoan){
            this.monthlyLoan = 0;
            super.setBalance(super.getBalance() + amount - monthlyLoan);
        }else{
            this.monthlyLoan -= amount;
        }
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }


    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyLoan() {
        return monthlyLoan;
    }

    public void initMonthlyLoan() {
        this.monthlyLoan = this.loanAmount / TERM_YEAR / 12 * (1 + MONTHLY_INTEREST);
    }

    public void setMonthlyLoan(double monthlyLoan) {
        this.monthlyLoan = monthlyLoan;
    }
}
