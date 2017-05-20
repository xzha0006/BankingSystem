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

    //constructor
    public HomeLoanAccount(){
        super();
        super.setType("homeLoan");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.startDate = sdf.format(new Date());
    }

    public double getMonthlyLoan(){
        return this.loanAmount / TERM_YEAR / 12 * (1 + MONTHLY_INTEREST);
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
}
