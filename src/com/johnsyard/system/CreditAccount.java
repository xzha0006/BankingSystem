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
    private String dueDate;
    private double loanOfLastMonth;
    private double dailyLimitation;
    private double currentCredit;
//    private String lastDueDate;
    //constructor
    public CreditAccount(){
        super();
        super.setType("credit");
        this.loanOfLastMonth = 0;
        this.currentCredit = CREDIT_AMOUNT;
    }

    @Override
    public void deposit(double amount){
        if (amount > this.loanOfLastMonth){
            super.setBalance(super.getBalance() + amount -this.loanOfLastMonth);
            this.currentCredit = CREDIT_AMOUNT;
        }else{
            this.loanOfLastMonth -= amount;
            this.currentCredit = CREDIT_AMOUNT - this.loanOfLastMonth;
        }
    }

    @Override
    public  void withdraw(double amount){
        if (amount < super.getBalance()){
            super.setBalance(super.getBalance() - amount);
        }else if(amount < super.getBalance() + this.currentCredit){
            this.currentCredit -= amount - super.getBalance();
            this.loanOfLastMonth = this.CREDIT_AMOUNT - this.currentCredit;
            super.setBalance(0);
        }
    }
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

    public String getDueDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        currentDate.setMonth(currentDate.getMonth()+1);
        currentDate.setDate(20);
        return sdf.format(currentDate);
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(double currentCredit) {
        this.currentCredit = currentCredit;
    }
}
