package com.johnsyard.system;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the term deposit account
 * Created by xuanzhang on 16/05/2017.
 */
public class TermDepositAccount extends Account {
    private final double MIN_AMOUNT = 10000;
    private final double MONTHLY_INTEREST = 0.05;

    private int termOfMonth;
    private String startDate;
    private String endDate;

    public TermDepositAccount(){
        super();
        super.setType("termDeposit");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.startDate = sdf.format(new Date());
    }

    public double getMIN_AMOUNT() {
        return MIN_AMOUNT;
    }

    public double getMONTHLY_INTEREST() {
        return MONTHLY_INTEREST;
    }

    public int getTermOfMonth() {
        return termOfMonth;
    }

    public void setTermOfMonth(int termOfMonth) {
        this.termOfMonth = termOfMonth;
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
}
