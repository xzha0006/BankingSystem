package com.johnsyard.system;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the term deposit account
 * Created by xuanzhang on 16/05/2017.
 */
public class TermDepositAccount extends Account {
    //interest Enum
    private enum Interest{
        THREE_MONTHS(3, 0.03),
        SIX_MONTHS(6, 0.04),
        TWELVE_MONTHS(7, 0.05);

        private int term;
        private double interest;

        Interest(int term, double interest){
            this.term = term;
            this.interest = interest;
        }
        //get interest from term
        public static double getInterestFromTerm(int term){
            double result = 0;
            for (Interest interestEnum: values()){
                if (interestEnum.term == term){
                    result = interestEnum.interest;
                }
            }
            return result;
        }
    }

    private int termOfMonth;
    private String startDate;
    private String endDate;
    private double monthlyInterest;

    public TermDepositAccount(){
        super();
        super.setType("termDeposit");
    }
    //constructor
    public TermDepositAccount(int termOfMonth){
        super();
        super.setType("termDeposit");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = sdf.format(new Date());
        this.termOfMonth = termOfMonth;
        this.monthlyInterest = Interest.getInterestFromTerm(termOfMonth);
    }

    public double getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(double monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
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
